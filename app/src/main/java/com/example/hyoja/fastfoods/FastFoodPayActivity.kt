package com.example.hyoja.fastfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hyoja.Fragments.FastFoodStep3Fragment
import com.example.hyoja.Fragments.checkCancelFragment
import com.example.hyoja.R
import com.example.hyoja.cafe.adapter.TotalFoodListAdapter
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodPayBinding
import com.example.hyoja.databinding.FragmentFastFoodStep3Binding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.PayStep
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FastFoodPayActivity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private val Tag:String = "FastFoodPayActivity"

    private lateinit var viewModel: FoodListViewModel

    private lateinit var binding: ActivityFastfoodPayBinding
    val common = CommonUi()

    val payStep : PayStep = PayStep(
        step1 = "",
        step2 = "",
        step3 = ""
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodPayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.cancelButton.setOnClickListener {
            checkCancelFragment().show(
                supportFragmentManager, "checkCancelFragment"
            )
        }

        binding.payTotalPrice.text = FastFoodModel.priceToPay.toString()
        binding.haveToPayPrice.text = FastFoodModel.priceToPay.toString()

        binding.step1PackageBtn.setOnClickListener {
            resetStep1Buttons()
            binding.step1PackageBtn.setBackgroundResource(R.drawable.layout_border_red)
            payStep.step1 = "포장"
            Log.d("step1", payStep.toString())
            enableStep2Buttons() // payStep.step1이 선택되면 step2 버튼 활성화
        }

        binding.step1ShopBtn.setOnClickListener {
            resetStep1Buttons()
            binding.step1ShopBtn.setBackgroundResource(R.drawable.layout_border_red)
            payStep.step1 = "매장"
            Log.d("step1", payStep.toString())
            enableStep2Buttons() // payStep.step1이 선택되면 step2 버튼 활성화
        }
        totalFoodListAdded()
    }

    fun enableStep2Buttons() {
        if (payStep.step1 != "") {
            binding.step2OneBarcodeBtn.setOnClickListener {
                resetStep2Buttons()
                binding.step2OneBarcodeBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "롯데잇츠"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
            }

            binding.step2JoinDiscountBtn.setOnClickListener {
                resetStep2Buttons()
                binding.step2JoinDiscountBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "제휴사할인"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
            }

            binding.step2Accumulate.setOnClickListener {
                resetStep2Buttons()
                binding.step2Accumulate.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "LPOINT"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
            }

            binding.step2NoSelectBtn.setOnClickListener {
                resetStep2Buttons()
                binding.step2NoSelectBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "선택없음"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
            }
        }
    }

    fun enableStep3Buttons() {
        if (payStep.step1 != "" && payStep.step2 != "") {
            binding.step3CardBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3CardBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step3 = "신용카드"
                payDialog()
            }

            binding.step3MobileBarcodeBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3MobileBarcodeBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step3 = "모바일바코드"
                payDialog()
            }

            binding.step3LPadyBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3LPadyBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step3 = "LPAY"
                payDialog()
            }

            binding.step3NoSelectBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3NoSelectBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step3 = "선택없음"
                payDialog()
            }

        }
    }


    fun totalFoodListAdded(){
        binding.FoodSelectedList.layoutManager = LinearLayoutManager(this).also {
            it.orientation = LinearLayoutManager.VERTICAL
        }

        Log.d(Tag,"totalFoodListAdded called")

        binding.FoodSelectedList.adapter = TotalFoodListAdapter(binding)
    }

    fun resetStep1Buttons(){
        Log.d("reset1",payStep.toString())
        binding.step1PackageBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step1ShopBtn.setBackgroundResource(R.drawable.ready_white)
    }
    fun resetStep2Buttons(){
        Log.d("reset2",payStep.toString())
        binding.step2Accumulate.setBackgroundResource(R.drawable.ready_white)
        binding.step2NoSelectBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step2OneBarcodeBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step2JoinDiscountBtn.setBackgroundResource(R.drawable.ready_white)
    }
    fun resetStep3Buttons(){
        Log.d("reset3",payStep.toString())
        binding.step3CardBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step3NoSelectBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step3LPadyBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step3MobileBarcodeBtn.setBackgroundResource(R.drawable.ready_white)

    }
    fun payDialog(){
        FastFoodStep3Fragment().show(
            supportFragmentManager, "FastFoodStep3Fragment"
        )
    }
}