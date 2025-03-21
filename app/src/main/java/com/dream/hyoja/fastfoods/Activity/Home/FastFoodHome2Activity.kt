package com.dream.hyoja.fastfoods.Activity.Home

//import com.dream.hyoja.Adapter.MyAdapter
import FoodOrderedListAdapter
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.HorizontalScrollView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.dream.hyoja.Fragments.FoodList.SetOrOnlyFragment
import com.dream.hyoja.Fragments.CommonUI.checkCancelFragment
import com.dream.hyoja.R
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityFastfoodHome2Binding
import com.dream.hyoja.fastfoods.adapter.FoodListNewMenuAdapter
import com.dream.hyoja.fastfoods.adapter.FoodMenuCategoryAdapter
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.model.OrderingFood
import com.dream.hyoja.fastfoods.util.ApplyFoodOrderList
import com.dream.hyoja.fastfoods.util.FoodAddListner
import com.dream.hyoja.fastfoods.util.FoodUtilValue
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

class FastFoodHome2Activity : AppCompatActivity(), FoodAddListner{

    private val Tag:String = "FastFoodHome2Activity"

    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    lateinit var binding: ActivityFastfoodHome2Binding

    var common = CommonUi()
    private lateinit var viewModel: FoodListViewModel
    lateinit var viewPager: ViewPager2

    private val option :ArrayList<String> =ArrayList()

    private val setOption :ArrayList<String> =ArrayList()

    lateinit var orderingFood : OrderingFood

    var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        common = CommonUi()

        if (i == 0){
            FastFoodModel.foodSelectedList.clear()
            i++
        }
        FastFoodModel.currentActivity = this

        val view = this

//        HorizontalScrollView 오른쪽 버튼 눌렀을때
        val tabTitleRightBtn = findViewById<ImageView>(R.id.TabTitleRightBtn)
        val horizontalScrollView = findViewById<HorizontalScrollView>(R.id.TabBarTitleHorizontalScroll)

        tabTitleRightBtn.setOnClickListener{
            val scrollAmount = 500
            horizontalScrollView.smoothScrollBy(scrollAmount,0)
            Log.d("tabTitleRightBtn","TabTitleRightBtn")
        }

//        HorizontalScrollView 왼쪽 버튼 눌렀을때
        val tabTitleLeftBtn = findViewById<ImageView>(R.id.TabTitleLeftBtn)
        tabTitleLeftBtn.setOnClickListener{
            val scrollAmount = 500
            horizontalScrollView.smoothScrollBy(-scrollAmount,0)
            Log.d("tabTitleRightBtn","TabTitleRightBtn")
        }

        //홈으로
        binding.FastFoodHome.setOnClickListener{
            common.goToHome(view)
        }

        //선택완료
        binding.PayBtn.setOnClickListener {
            if (FastFoodModel.foodSelectedList.size == 0) {
                Toast.makeText(this, "메뉴를 선택해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                common.goToFastFoodPayHome(view)
                Log.d("패스트 푸드 결제시작", FastFoodModel.foodSelectedList.toString())
            }
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

        //메뉴 삭제
        binding.FoodSelectedList.layoutManager = LinearLayoutManager(this)

        //취소하기 하면 담은 거 전체 삭제
        binding.cancelButton.setOnClickListener {
            Log.d("cancelButton called","cancelButton called")
            checkCancelFragment().show(
                supportFragmentManager, "checkCancelFragment"
            )
        }

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

       var i=0
        viewModel.foodSelectedLiveData.observe(this, Observer {
            if(i>0){
                if(FastFoodModel.foodSelected.category == "NewMenu" || FastFoodModel.foodSelected.category == "Hamburger"){
                    Log.d(Tag,"drinkSelectedLiveData observed")

                    Log.d("viewModel.category",viewModel.category.toString())

                    foodOptionFragmentManage()
                }else{
                    orderingFood = OrderingFood(
                        food = FastFoodModel.foodSelected,
                        option = option,
                        setOption = setOption,
                        setDessert = null,
                        setDrink = null,
                        category = FastFoodModel.foodSelected.category
                    )
                    Log.d(Tag,orderingFood.toString())
                    addOnlyFood()
                    ApplyFoodOrderList(FastFoodModel.currentActivity).foodAdded()

                }

            }
            i++
        })


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
        })


        //selectedItems scrollView
//        val nestedScrollView = findViewById<NestedScrollView>(R.id.nestedScrollView)
        val upButton = findViewById<View>(R.id.upButton)
        val downButton = findViewById<View>(R.id.downButton)

        upButton.setOnClickListener {
//            nestedScrollView.smoothScrollBy(0, -200) // Adjust the scroll amount as needed
        }

        downButton.setOnClickListener {
//            nestedScrollView.smoothScrollBy(0, 200) // Adjust the scroll amount as needed
        }
    }
    override fun onBackPressed() {
        // 뒤로가기 막기
        val currentTime = System.currentTimeMillis()
        val commonUi:CommonUi = CommonUi()
        val view = this

        if (currentTime - backPressedTime < 2000) {
            commonUi.goToHome(view)
            finish()
        } else {
            Toast.makeText(this, "한 번 더 누르면 메인화면으로 전환합니다", Toast.LENGTH_SHORT).show()
            backPressedTime = currentTime
        }
    }

    fun deleteFood(food: OrderingFood){
        FastFoodModel.foodSelectedList.remove(food)
        binding.FoodSelectedList.adapter?.notifyDataSetChanged()
    }

    private fun addOnlyFood(){
        var isSame = false

        Log.d("addOnlyBurger",FastFoodModel.foodSelectedList.toString())
        onlyFoodApplyPay()

        for (i in 0..FastFoodModel.foodSelectedList.size-1){
            Log.d("addOnlyBurger food name",FastFoodModel.foodSelectedList[i].food.name.toString())
            Log.d("addOnlyBurger ordering food name",orderingFood.food.name.toString())

            Log.d("addOnlyBurger food totalPrice",FastFoodModel.foodSelectedList[i].totalPrice.toString())
            Log.d("addOnlyBurger ordering food totalPrice",orderingFood.totalPrice.toString())

            Log.d("addOnlyBurger ordering food totalPrice",orderingFood.toString())


            if(FastFoodModel.foodSelectedList[i].food.name == orderingFood.food.name && FastFoodModel.foodSelectedList[i].totalPrice == orderingFood.totalPrice){
                isSame = true
                FastFoodModel.foodSelectedList[i].foodCount++
            }
        }

        if (!isSame){
            FastFoodModel.foodSelectedList.add(orderingFood)
        }

        Log.d(Tag,FastFoodModel.foodSelectedList.toString())

        viewModel.orderListChanged()
        Log.d(Tag,FastFoodModel.foodSelectedList.toString())

    }
    private fun onlyFoodApplyPay(){
        var payment : Int = (FastFoodModel.foodSelected.price)
        orderingFood.totalPrice =  payment
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

    private fun foodOptionFragmentManage(){
        Log.d(Tag, "foodOptionFragmentMange 호출됨")

        SetOrOnlyFragment().show(
            supportFragmentManager, "DrinkOrderAddDialogFragment"
        )

    }

    fun getToTalPrice(): Int{
        var account:Int = 0

        for (i in 0..FastFoodModel.foodSelectedList.size - 1){
            account += FastFoodModel.foodSelectedList[i].totalPrice * FastFoodModel.foodSelectedList[i].foodCount
            Log.d(Tag,FastFoodModel.foodSelectedList[i].toString())
            Log.d("FastFoodModel.foodSelectedList[i].price",FastFoodModel.foodSelectedList[i].totalPrice.toString())

        }
        FastFoodModel.priceToPay = account
        Log.d("totalAccount",account.toString())
        return account
    }

    fun getToTalCount(): Int{
        var count:Int = 0

        for (i in 0..FastFoodModel.foodSelectedList.size - 1){
            count += FastFoodModel.foodSelectedList[i].foodCount
        }
        return count
    }

    override fun foodAdded() {
        //장바구니 리사이클리뷰
        binding.FoodSelectedList.layoutManager = LinearLayoutManager(this).also{
            it.orientation = LinearLayoutManager.VERTICAL
        }

        Log.d(Tag,"foodAdded 함수 called")

        binding.FoodSelectedList.adapter = FoodOrderedListAdapter(binding)

        //총 결제 금액 세팅
        updateTotalFoodInfo()
    }

    override fun foodSet() {
        ApplyFoodOrderList(FastFoodModel.currentActivity).foodAdded()
    }

    fun updateTotalFoodInfo(){
        binding.TotalOrderPrice.text = getToTalPrice().toString()
        binding.TotalOrderCount.text = "${getToTalCount().toString()}개"
    }
}


