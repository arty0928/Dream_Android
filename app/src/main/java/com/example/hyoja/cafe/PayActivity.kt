package com.example.hyoja.cafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hyoja.cafe.adapter.PayViewPagerAdapter
import com.example.hyoja.cafe.fragment.PayFragment
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityPayBinding

class PayActivity : AppCompatActivity() {
    lateinit var binding: ActivityPayBinding
    lateinit var payViewPagerAdapter: PayViewPagerAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CafeModel.ActivityStatus = this

        payViewPagerAdapter = PayViewPagerAdapter(this)

        binding.viewPager.adapter = payViewPagerAdapter
    }

    private var backPressedTime:Long = 0
    override fun onBackPressed() {
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

    override fun onResume() {
        super.onResume()
    }
}