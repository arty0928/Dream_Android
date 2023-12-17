package com.dream.hyoja.cafe

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.dream.hyoja.R
import com.dream.hyoja.cafe.fragment.DrinkOrderAddDialogFragment
import com.dream.hyoja.cafe.model.CafeModel
import com.dream.hyoja.common.ManualDialog
import com.dream.hyoja.common.SplashActivity
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.common.util.ManualStepChecker
import com.dream.hyoja.databinding.ActivityCafeHomeBinding

class CafeHomeActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0
    private lateinit var binding: ActivityCafeHomeBinding
    val common = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCafeHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        SplashActivity.sharedPreferences = getSharedPreferences("HyoJaPreference", Context.MODE_PRIVATE)
        val first = SplashActivity.sharedPreferences.getBoolean("First",true)

        if (first){
            ManualDialog().show(
                    supportFragmentManager, "ManualDialog"
            )
            val anim = AnimationUtils.loadAnimation(this, R.anim.blink)
            binding.forHere.startAnimation(anim)
        }



        binding.forHere.setOnClickListener{
            common.goToCafeHome1(view)
            CafeModel.pickOrMarket = true

            ManualStepChecker.cafeForHereStep = true
            binding.forHere.clearAnimation()
        }

        binding.toGo.setOnClickListener{
            common.goToCafeHome1(view)
            CafeModel.pickOrMarket = false

            ManualStepChecker.cafeForHereStep = true
            binding.forHere.clearAnimation()
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
}
