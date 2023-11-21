package com.example.hyoja.cafe.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hyoja.cafe.adapter.PayViewPagerAdapter
import com.example.hyoja.cafe.fragment.PayFragment
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityPayBinding

class PayActivity : AppCompatActivity(), PayFragment.NextListener {
    lateinit var binding: ActivityPayBinding
    private val payViewPagerAdapter = PayViewPagerAdapter(this)
    private var currentItem = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        CafeModel.ActivityStatus = this

        binding.viewPager.adapter = payViewPagerAdapter
        binding.viewPager.isUserInputEnabled = false
        payViewPagerAdapter.setNextListener(this)
        binding.price.text = CafeModel.getTotalPrice().toString()
        binding.remainPrice.text = CafeModel.getTotalPrice().toString()

        binding.allCancel.setOnClickListener {
            CafeModel.drinkSelectedList.clear()
            CommonUi().goToCafeHome1(this)
        }
        binding.back.setOnClickListener {
            if (currentItem == 0){
                this.finish()
            } else {
                binding.viewPager.currentItem = --currentItem
            }

        }
        binding.next.setOnClickListener {
            if (currentItem == 1){
                startActivity(Intent(this,CardActivity::class.java))
            }else{
                binding.viewPager.currentItem = ++currentItem
            }

        }
    }

    private var backPressedTime:Long = 0
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

    override fun onResume() {
        super.onResume()
    }

    override fun setNextItem() {
        binding.viewPager.setCurrentItem(2,true)
    }
}