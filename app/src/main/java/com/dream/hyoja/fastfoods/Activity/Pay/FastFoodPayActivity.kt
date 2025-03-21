package com.dream.hyoja.fastfoods.Activity.Pay

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import com.dream.hyoja.Fragments.Pay.FastFoodStep3Fragment
import com.dream.hyoja.Fragments.Pay.PayFragment
import com.dream.hyoja.Fragments.CommonUI.checkCancelFragment
import com.dream.hyoja.R
import com.dream.hyoja.cafe.adapter.TotalFoodListAdapter
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityFastfoodPayBinding
import com.dream.hyoja.fastfoods.model.FastFoodModel
import com.dream.hyoja.fastfoods.model.PayStep
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

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

        binding.FastFoodHome.setOnClickListener {
            common.goToHome(view)
        }

        binding.payTotalPrice.text = FastFoodModel.priceToPay.toString()
        binding.haveToPayPrice.text = FastFoodModel.priceToPay.toString()

        val anim = AnimationUtils.loadAnimation(this, R.anim.blink)
        binding.step1Box.startAnimation(anim)

        binding.step1PackageBtn.setOnClickListener {
            binding.step1Box.clearAnimation()
            resetStep1Buttons()
            binding.step1PackageBtn.setBackgroundResource(R.drawable.layout_border_red)
            binding.step1PackageText2.setTextColor(Color.parseColor("#000000"))
            binding.step1PackageText1.setTextColor(Color.parseColor("#000000"))
            
            binding.payWay.text = "포장"

            binding.step1PackageBtnImage.setImageResource(R.drawable.bag)
            payStep.step1 = "포장"
            Log.d("step1", payStep.toString())
            enableStep2Buttons() // payStep.step1이 선택되면 step2 버튼 활성화
        }

        binding.step1ShopBtn.setOnClickListener {
            binding.step1Box.clearAnimation()
            resetStep1Buttons()
            binding.step1ShopBtn.setBackgroundResource(R.drawable.layout_border_red)

            binding.payWay.text = "매장"
            
            binding.step1shBtnImage.setImageResource(R.drawable.shop)
            binding.step1ShopText2.setTextColor(Color.parseColor("#000000"))
            binding.step1ShopText1.setTextColor(Color.parseColor("#000000"))
            payStep.step1 = "매장"
            Log.d("step1", payStep.toString())
            enableStep2Buttons() // payStep.step1이 선택되면 step2 버튼 활성화
        }
        totalFoodListAdded()
    }

    fun enableStep2Buttons() {
        binding.step1Box.setBackgroundResource(R.drawable.layout_darkgray_5dp)
        binding.step1Bar.setBackgroundColor(Color.parseColor("#979797"));

        if(payStep.step2==""){
            binding.step2Box.setBackgroundResource(R.drawable.layout_border_red)
            binding.step2Bar.setBackgroundColor(Color.parseColor("#C80000"));
        }

        if (payStep.step1 != "") {
            binding.step2OneBarcodeBtn.setOnClickListener {
                resetStep2Buttons()
                binding.step2OneBarcodeBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "롯데잇츠"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
                binding.step2OneBarcodeBtnText.setTextColor(Color.parseColor("#000000"))
            }

            binding.step2JoinDiscountBtn.setOnClickListener {
                resetStep2Buttons()
                binding.step2JoinDiscountBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "제휴사할인"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
                binding.step2JoinDiscountBtnText.setTextColor(Color.parseColor("#000000"))
            }

            binding.step2Accumulate.setOnClickListener {
                resetStep2Buttons()
                binding.step2Accumulate.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "LPOINT"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
                binding.step2AccumulateText.setTextColor(Color.parseColor("#000000"))
            }

            binding.step2NoSelectBtn.setOnClickListener {
                resetStep2Buttons()
                binding.step2NoSelectBtn.setBackgroundResource(R.drawable.layout_border_red)
                payStep.step2 = "선택없음"
                enableStep3Buttons() // payStep.step2가 선택되면 step3 버튼 활성화
                binding.step2NoSelectBtnText.setTextColor(Color.parseColor("#000000"))
            }
        }
    }

    fun enableStep3Buttons() {
        binding.step2Box.setBackgroundResource(R.drawable.layout_darkgray_5dp)
        binding.step2Bar.setBackgroundColor(Color.parseColor("#979797"));
        binding.step3Box.setBackgroundResource(R.drawable.layout_border_red)
        binding.step3Bar.setBackgroundColor(Color.parseColor("#C80000"));


        if (payStep.step1 != "" && payStep.step2 != "") {
            binding.step3CardBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3CardBtn.setBackgroundResource(R.drawable.layout_border_red)

                binding.step3CardBtnText.setTextColor(Color.parseColor("#000000"))
                binding.step3CardBtnImage.setImageResource(R.drawable.card)

                payStep.step3 = "신용카드"

                PayFragment().show(
                    supportFragmentManager, "PayFragment"
                )

            }

            binding.step3MobileBarcodeBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3MobileBarcodeBtn.setBackgroundResource(R.drawable.layout_border_red)
                binding.step3MobileBarcodeBtnText.setTextColor(Color.parseColor("#000000"))
                binding.step3MobileBarcodeBtnImage.setImageResource(R.drawable.barcode_line)


                payStep.step3 = "모바일바코드"
                payDialog()
            }

            binding.step3LPadyBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3LPadyBtn.setBackgroundResource(R.drawable.layout_border_red)
                binding.step3LPadyBtnText.setTextColor(Color.parseColor("#000000"))

                binding.step3LPadyBtnImage.setImageResource(R.drawable.lpay)

                payStep.step3 = "LPAY"
                payDialog()
            }

            binding.step3NoSelectBtn.setOnClickListener {
                resetStep3Buttons()
                binding.step3NoSelectBtnText.setTextColor(Color.parseColor("#000000"))
                binding.step3NoSelectBtn.setBackgroundResource(R.drawable.layout_border_red)
                binding.step3NoSelectBtnImage.setImageResource(R.drawable.tmoney)

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

        binding.step1shBtnImage.setImageResource(R.drawable.shop_gray)
        binding.step1PackageBtnImage.setImageResource(R.drawable.bag_gray)


        binding.step1PackageText1.setTextColor(Color.parseColor("#979797"));
        binding.step1PackageText2.setTextColor(Color.parseColor("#979797"));
        binding.step1ShopText1.setTextColor(Color.parseColor("#979797"));
        binding.step1ShopText2.setTextColor(Color.parseColor("#979797"));

        val anim = AnimationUtils.loadAnimation(this, R.anim.blink)
        binding.step2Box.startAnimation(anim)

    }
    fun resetStep2Buttons(){
        binding.step2Box.clearAnimation()

        val anim = AnimationUtils.loadAnimation(this, R.anim.blink)
        binding.step3Box.startAnimation(anim)

        Log.d("reset2",payStep.toString())
        binding.step2Accumulate.setBackgroundResource(R.drawable.ready_white)
        binding.step2NoSelectBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step2OneBarcodeBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step2JoinDiscountBtn.setBackgroundResource(R.drawable.ready_white)

        binding.step2AccumulateText.setTextColor(Color.parseColor("#979797"));
        binding.step2NoSelectBtnText.setTextColor(Color.parseColor("#979797"));
        binding.step2JoinDiscountBtnText.setTextColor(Color.parseColor("#979797"));
        binding.step2OneBarcodeBtnText.setTextColor(Color.parseColor("#979797"));


    }
    fun resetStep3Buttons(){


        Log.d("reset3",payStep.toString())
        binding.step3CardBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step3NoSelectBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step3LPadyBtn.setBackgroundResource(R.drawable.ready_white)
        binding.step3MobileBarcodeBtn.setBackgroundResource(R.drawable.ready_white)


        binding.step3CardBtnImage.setImageResource(R.drawable.card_gray)
        binding.step3LPadyBtnImage.setImageResource(R.drawable.lpay)
        binding.step3MobileBarcodeBtnImage.setImageResource(R.drawable.barcode_gray)
        binding.step3NoSelectBtnImage.setImageResource(R.drawable.tmoney_gray)


        binding.step3CardBtnText.setTextColor(Color.parseColor("#979797"));
        binding.step3NoSelectBtnText.setTextColor(Color.parseColor("#979797"));
        binding.step3LPadyBtnText.setTextColor(Color.parseColor("#979797"));
        binding.step3MobileBarcodeBtnText.setTextColor(Color.parseColor("#979797"));


    }
    fun payDialog(){
        FastFoodStep3Fragment().show(
            supportFragmentManager, "FastFoodStep3Fragment"
        )
    }
}