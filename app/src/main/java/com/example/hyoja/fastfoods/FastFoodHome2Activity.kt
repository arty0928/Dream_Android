package com.example.hyoja.fastfoods

//import com.example.hyoja.Adapter.MyAdapter
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.hyoja.Fragments.drink
import com.example.hyoja.Fragments.FoodListMenuOneFrament
import com.example.hyoja.Fragments.FoodListMenuTwoFragment
import com.example.hyoja.Fragments.SetOrOnlyFragment
import com.example.hyoja.Fragments.lunch
import com.example.hyoja.R
import com.example.hyoja.cafe.fragment.DrinkOrderAddDialogFragment
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.util.UtilValue
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodHome2Binding
import com.example.hyoja.fastfoods.adapter.FoodListNewMenuAdapter
import com.example.hyoja.fastfoods.adapter.FoodMenuCategoryAdapter
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.util.FoodUtilValue
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FastFoodHome2Activity : AppCompatActivity(){

    private val Tag:String = "FastFoodHome2Activity"

    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    lateinit var binding: ActivityFastfoodHome2Binding

    val common = CommonUi()
    private lateinit var viewModel: FoodListViewModel

    lateinit var viewPager: ViewPager2

//    override fun onResume() {
//        super.onResume()
//        binding.root.requestLayout()
//    }

    //        selectedItems scrollView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        val view = this

//        HorizontalScrollView 오른쪽 버튼 눌렀을때
        val tabTitleRightBtn = findViewById<ImageView>(R.id.TabTitleRightBtn)
        val horizontalScrollView = findViewById<HorizontalScrollView>(R.id.TabBarTitleHorizontalScroll)

        tabTitleRightBtn.setOnClickListener{
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(scrollAmount,0)
            Log.d("tabTitleRightBtn","TabTitleRightBtn")
        }

//        HorizontalScrollView 왼쪽 버튼 눌렀을때
        val tabTitleLeftBtn = findViewById<ImageView>(R.id.TabTitleLeftBtn)
        tabTitleLeftBtn.setOnClickListener{
            val scrollAmount = 300
            horizontalScrollView.smoothScrollBy(-scrollAmount,0)
            Log.d("tabTitleRightBtn","TabTitleRightBtn")
        }
        
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]
        
        //카테고리 뷰페이저
        binding.FastFoodCategoryList.adapter = FoodMenuCategoryAdapter(this)
        var currentItem = binding.FastFoodCategoryList.currentItem
        binding.FastFoodCategoryList.isUserInputEnabled = false;

        //푸드리스트 뷰페이저
        Log.d("FoodMenuListViewPager link","start called")
        binding.FoodMenuList.adapter = FoodListNewMenuAdapter(this)
        binding.FoodMenuList.isUserInputEnabled = false;
        Log.d("FoodMenuListViewPager link","after called")


        //메뉴 리스트 왼쪽 버튼
        binding.FoodMenuListListLeftButton.setOnClickListener {
            if(checkFoodListViewPagerSize(FastFoodModel.menuCategory)>1){
                binding.FoodMenuList.setCurrentItem(0,true)
                binding.FoodMenuListListLeftButton.setImageResource(R.drawable.icon_left_un)
                binding.FoodMenuListListRightButton.setImageResource(R.drawable.icon_right)
            }
        }

        binding.FoodMenuListListRightButton.setOnClickListener {
            if(checkFoodListViewPagerSize(FastFoodModel.menuCategory)>1){
                binding.FoodMenuList.setCurrentItem(1,true)
                binding.FoodMenuListListLeftButton.setImageResource(R.drawable.icon_left)
                binding.FoodMenuListListRightButton.setImageResource(R.drawable.icon_right_un)
            }
        }

        //선택한 카테고리에 따라서 바뀌는 음료리스트
        viewModel.categoryLiveData.observe(this, Observer {
            when(it){
                "newMenu" -> {
                    // 버튼 활성화 비활성화 선택
                    foodListButtonSrcSelect(checkFoodListViewPagerSize(it))
                }
                "hamburger" -> {
                    foodListButtonSrcSelect(checkFoodListViewPagerSize(it))
                }
                "dessert" -> {
                    foodListButtonSrcSelect(checkFoodListViewPagerSize(it))
                }
                "drink" -> {
                    foodListButtonSrcSelect(checkFoodListViewPagerSize(it))
                }
                else -> {

                }
            }
//            binding.FoodMenuList.adapter = FoodListNewMenuAdapter(this,it)
//            binding.FoodMenuList.isUserInputEnabled = false;

        })

        //음료리스트에서 음료 선택 시 옵션 선택 프래그먼트 생성
        //처음 init 막는 로직 필요
        var i=0
        viewModel.foodSelectedListLiveData.observe(this, Observer {
            if(i>0){
                Log.d(Tag,"foodSelectedLiveData observed")
                foodOptionFragmentMange()
            }
            i++
        })

        //selectedItems scrollView
        val nestedScrollView = findViewById<NestedScrollView>(R.id.nestedScrollView)
        val upButton = findViewById<View>(R.id.upButton)
        val downButton = findViewById<View>(R.id.downButton)

        upButton.setOnClickListener {
            nestedScrollView.smoothScrollBy(0, -200) // Adjust the scroll amount as needed
        }

        downButton.setOnClickListener {
            nestedScrollView.smoothScrollBy(0, 200) // Adjust the scroll amount as needed
        }
    }

    private fun checkFoodListViewPagerSize(categroyName: String):Int{
        //null허용은 해놨는데 절대 null되면 안됨
        var value = FoodUtilValue()
        var itemCount: Int? = when(categroyName){
            "newMenu" -> {
                value.newMenuListSize
            }
            "hamburger" -> {
                value.hamburgerListSize
            }
            "dessert" -> {
                value.dessertListSize
            }
            "drink" -> {
                value.drinkListSize
            }
            else ->{
                return 0
            }
        }
        Log.d(Tag,"FoodListCount = "+ itemCount.toString())
        // 뷰페이저 첫번째 프래그먼트로 전환
        binding.FoodMenuList.setCurrentItem(0,true)
        itemCount = itemCount?.div(6)
        return itemCount!!
    }

    private fun foodListButtonSrcSelect(itemCount:Int){
        if (itemCount == 1){
            binding.FoodMenuListListLeftButton.setImageResource(R.drawable.icon_left_un)
            binding.FoodMenuListListRightButton.setImageResource(R.drawable.icon_right_un)
        }
        else if(itemCount <= 0){
            binding.FoodMenuListListRightButton.setImageResource(R.drawable.icon_right_un)
            binding.FoodMenuListListLeftButton.setImageResource(R.drawable.icon_left_un)
        }
        else{
            binding.FoodMenuListListRightButton.setImageResource(R.drawable.icon_right)
            binding.FoodMenuListListLeftButton.setImageResource(R.drawable.icon_left_un)
        }
    }
    private fun foodOptionFragmentMange(){
        Log.d(Tag,"food_choose_set_or_only_dialog_FragmentMange called")
//            SetOrOnlyFragment().show(
//            supportFragmentManager, "DrinkOrderAddDialogFragment"
//        )
        Log.d(Tag,"DrinkOrderAddDialogFragment().show")
    }


}


