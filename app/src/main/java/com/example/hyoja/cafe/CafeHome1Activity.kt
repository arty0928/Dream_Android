package com.example.hyoja.cafe

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.adapter.DrinkListAdeAdapter
import com.example.hyoja.cafe.adapter.DrinkListBaverageAdapter
import com.example.hyoja.cafe.adapter.DrinkListBubbleMilkAdapter
import com.example.hyoja.cafe.adapter.DrinkListCoffeeAdapter
import com.example.hyoja.cafe.adapter.DrinkListFlatccinoAdapter
import com.example.hyoja.cafe.adapter.DrinkListNewMenuAdapter
import com.example.hyoja.cafe.adapter.DrinkListShakeAdapter
import com.example.hyoja.cafe.adapter.DrinkListTeaAdapter
import com.example.hyoja.cafe.adapter.MenuCategoryAdapter
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityCafeHome1Binding


class CafeHome1Activity : AppCompatActivity() {
    private val Tag:String = "CafeHome1Activity"
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언

    private lateinit var binding: ActivityCafeHome1Binding
    private var coffeePopup: PopupWindow? = null
    private lateinit var viewModel: MenuListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCafeHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //goTo쓰려고 Common 객체 생성
        val view = this
        val commonUi:CommonUi = CommonUi()

        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(this)[MenuListViewModel::class.java]

        //카테고리 뷰페이저
        binding.menuList.adapter = MenuCategoryAdapter(this)
        var currentItem = binding.menuList.currentItem
        binding.menuList.isUserInputEnabled = false;


        //기본적으로 왼쪽 오른쪽 버튼은 해당 Item이 2개라고 가정하고 그냥 작성해놓음... 호오오옥시 나중에 발전시키려면 이거 수정해야함
        //카테고리 리스트 왼쪽 버튼
        binding.leftButton.setOnClickListener{
            if(currentItem == 1){
                currentItem = 0
                binding.menuList.setCurrentItem(0,true)
                binding.leftButton.setImageResource(R.drawable.left_arrow_white)
                binding.rightButton.setImageResource(R.drawable.right_arrow_red)
            }
        }
        //카테고리 리스트 오른쪽 버튼
        binding.rightButton.setOnClickListener{
            if(currentItem == 0){
                currentItem = 1
                binding.menuList.setCurrentItem(1,true)
                binding.leftButton.setImageResource(R.drawable.left_arrow_red)
                binding.rightButton.setImageResource(R.drawable.right_arrow_white)
            }
        }
        //음료 리스트 왼쪽 버튼
        binding.drinkListLeftButton.setOnClickListener{
            if(checkDrinkListViewPagerSize(CafeModel.menuCategory)>1){
                binding.drinkList.setCurrentItem(0,true)
                binding.drinkListLeftButton.setImageResource(R.drawable.icon_left_un)
                binding.drinkListRightButton.setImageResource(R.drawable.icon_right)
            }
        }
        //음료 리스트 오른쪽 버튼
        binding.drinkListRightButton.setOnClickListener{
            if(checkDrinkListViewPagerSize(CafeModel.menuCategory)>1){
                binding.drinkList.setCurrentItem(1,true)
                binding.drinkListLeftButton.setImageResource(R.drawable.icon_left)
                binding.drinkListRightButton.setImageResource(R.drawable.icon_right_un)
            }
        }

        //선택한 카테고리에 따라서 바뀌는 음료리스트
        viewModel.categoryLiveData.observe(this, Observer {
            when(it){
                "newMenu" -> {
                    binding.drinkList.adapter = DrinkListNewMenuAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "ade" -> {
                    binding.drinkList.adapter = DrinkListAdeAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "shake" -> {
                    binding.drinkList.adapter = DrinkListShakeAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "coffee" -> {
                    binding.drinkList.adapter = DrinkListCoffeeAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "tea" -> {
                    binding.drinkList.adapter = DrinkListTeaAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "flatccino" -> {
                    binding.drinkList.adapter = DrinkListFlatccinoAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "baverage" -> {
                    binding.drinkList.adapter = DrinkListBaverageAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "bubbleMilk" -> {
                    binding.drinkList.adapter = DrinkListBubbleMilkAdapter(this)
                    binding.drinkList.isUserInputEnabled = false;
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
            }
        })


        //처음으로 버튼
        binding.cafeHome.setOnClickListener{
            commonUi.goToCafe(view)
        }
        binding.cafeHomeText.setOnClickListener{
            commonUi.goToCafe(view)
        }

    }
    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()
        val commonUi:CommonUi = CommonUi()
        val view = this

        if (currentTime - backPressedTime < 2000) {
            commonUi.goToHome(view)
        } else {
            Toast.makeText(this, "한 번 더 누르면 메인화면으로 전환합니다", Toast.LENGTH_SHORT).show()
            backPressedTime = currentTime
        }
    }
    fun checkDrinkListViewPagerSize(categroyName: String):Int{
        //null허용은 해놨는데 절대 null되면 안됨
        var itemCount: Int? = 0
        itemCount = binding.drinkList.adapter?.itemCount
        Log.d(Tag,"drinkListCount = "+ itemCount.toString())
        return itemCount!!
    }
    fun drinkListButtonSrcSelect(itemCount:Int){
        if (itemCount == 1){
            binding.drinkListRightButton.setImageResource(R.drawable.icon_right_un)
            binding.drinkListLeftButton.setImageResource(R.drawable.icon_left_un)
        }
        else if(itemCount <= 0){
            binding.drinkListRightButton.setImageResource(R.drawable.icon_right_un)
            binding.drinkListLeftButton.setImageResource(R.drawable.icon_left_un)
        }
        else{
            binding.drinkListRightButton.setImageResource(R.drawable.icon_right)
            binding.drinkListLeftButton.setImageResource(R.drawable.icon_left_un)
        }
    }
}
