package com.dream.hyoja.cafe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dream.hyoja.R
import com.dream.hyoja.cafe.activity.PayActivity
import com.dream.hyoja.cafe.adapter.DrinkListNewMenuAdapter
import com.dream.hyoja.cafe.adapter.MenuCategoryAdapter
import com.dream.hyoja.cafe.adapter.OrderedListAdapter
import com.dream.hyoja.cafe.fragment.DrinkOrderAddDialogFragment
import com.dream.hyoja.cafe.model.CafeModel
import com.dream.hyoja.cafe.util.DrinkAddListner
import com.dream.hyoja.cafe.util.UtilValue
import com.dream.hyoja.cafe.viewmodel.MenuListViewModel
import com.dream.hyoja.common.ManualDialog
import com.dream.hyoja.common.SplashActivity
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.common.util.ManualStepChecker
import com.dream.hyoja.databinding.ActivityCafeHome1Binding

class CafeHome1Activity : AppCompatActivity(), DrinkAddListner {
    private val Tag:String = "CafeHome1Activity"
    private var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언

    private lateinit var binding: ActivityCafeHome1Binding
    private var coffeePopup: PopupWindow? = null
    private lateinit var viewModel: MenuListViewModel

    private lateinit var rightButtonManual: Animation
    private lateinit var leftButtonManual: Animation
    private lateinit var rightDrinkButtonManual: Animation
    private lateinit var leftDrinkManual: Animation



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCafeHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        CafeModel.currentActivity = this
        CafeModel.ActivityStatus = this


        //goTo쓰려고 Common 객체 생성
        val view = this
        val commonUi = CommonUi()

        //이곳으로 오면 선택했던 리스트는 모두 초기화됨
        clearSelectedDrinkList()

        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(this)[MenuListViewModel::class.java]

        //카테고리 뷰페이저
        binding.menuList.adapter = MenuCategoryAdapter(this)
        var currentItem = binding.menuList.currentItem
        binding.menuList.isUserInputEnabled = false;

        //음료리스트 뷰페이저 띄우기
        binding.drinkList.adapter = DrinkListNewMenuAdapter(this)
        binding.drinkList.isUserInputEnabled = false;

        //결제하기 버튼
        binding.payButton.setOnClickListener {
            if(CafeModel.drinkSelectedList.size == 0){

            }
            else{
                goToPay(this)
                Log.d("결제시작",CafeModel.drinkSelectedList.toString())
            }
        }

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

        // 전체 취소
        binding.allClear.setOnClickListener {
            CafeModel.drinkSelectedList.clear()
            drinkAdded()
        }

        //선택한 카테고리에 따라서 바뀌는 음료리스트
        viewModel.categoryLiveData.observe(this, Observer {
            when(it){
                "newMenu" -> {
                    // 버튼 활성화 비활성화 선택
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "ade" -> {
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "shake" -> {
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "coffee" -> {
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "tea" -> {
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "flatccino" -> {
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "beverage" -> {
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                "bubbleMilk" -> {
                    drinkListButtonSrcSelect(checkDrinkListViewPagerSize(it))
                }
                else -> {

                }
            }
        })

        //음료리스트에서 음료 선택 시 옵션 선택 프래그먼트 생성
        //처음 init 막는 로직 필요
        var i=0
        viewModel.drinkSelectedLiveData.observe(this, Observer {
            if(i>0){
                Log.d(Tag,"drinkSelectedLiveData observed")
                drinkOptionFragmentMange()
            }
            i++
        })
        //처음으로 버튼
        binding.cafeHome.setOnClickListener{
            commonUi.goToHome(view)
        }
        binding.cafeHomeText.setOnClickListener{
            commonUi.goToHome(view)
        }

    }
    override fun onBackPressed() {
        super.onBackPressed()
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
    private fun checkDrinkListViewPagerSize(categroyName: String):Int{
        //null허용은 해놨는데 절대 null되면 안됨
        var value = UtilValue()
        var itemCount: Int? = when(categroyName){
            "newMenu" -> {
                value.newMenuListSize
            }
            "ade" -> {
                value.adeListSize
            }
            "shake" -> {
                value.shakeListSize
            }
            "coffee" -> {
                value.coffeeListSize
            }
            "tea" -> {
                value.teaListSize
            }
            "flatccino" -> {
                value.flatccinoListSize
            }
            "beverage" -> {
                value.beverageListSize
            }
            "bubbleMilk" -> {
                value.bubbleMilkSize
            }
            else ->{
                return 0
            }
        }
        Log.d(Tag,"drinkListCount = "+ itemCount.toString())
        // 뷰페이저 첫번째 프래그먼트로 전환
        binding.drinkList.setCurrentItem(0,true)
        itemCount = itemCount?.div(4)
        return itemCount!!
    }
    private fun drinkListButtonSrcSelect(itemCount:Int){
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
    //음료 선택 시 음료상세주문 띄우기
    private fun drinkOptionFragmentMange(){
        Log.d(Tag,"drinkOptionFragmentMange called")
        DrinkOrderAddDialogFragment().show(
            supportFragmentManager, "DrinkOrderAddDialogFragment"
        )
        Log.d(Tag,"DrinkOrderAddDialogFragment().show")
    }
    private fun clearSelectedDrinkList(){
        CafeModel.drinkSelectedList.clear()
    }
    private fun getTotalPrice(): Int{
        var account: Int = 0
        for (i in 0 until CafeModel.drinkSelectedList.size){
            account += CafeModel.drinkSelectedList[i].price
        }
        Log.d(Tag,account.toString())
        return account
    }

    // 음료주문 선택 완료하면 콜백되는 콜백 함수
    override fun drinkAdded() {
        var orderedListAdapter = OrderedListAdapter()
        // 장바구니 리사이클러뷰
        binding.drinkSelectedList.layoutManager = LinearLayoutManager(this).also { it.orientation = LinearLayoutManager.HORIZONTAL }
        binding.drinkSelectedList.adapter = orderedListAdapter

        // 총 결제 금액 세팅
        binding.account.text = getTotalPrice().toString()
    }
    override fun drinkPriceSet() {
        var account = 0
        for (i in 0 until CafeModel.drinkSelectedList.size){
            account += CafeModel.drinkSelectedList[i].price
        }
        binding.account.text = account.toString()
        Log.d("drinkPriceSet",account.toString())
    }

    private fun goToPay(context: Context){
        val intent = Intent(context, PayActivity::class.java)
        context.startActivity(intent)
    }




}