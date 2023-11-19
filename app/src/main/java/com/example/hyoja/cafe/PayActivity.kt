package com.example.hyoja.cafe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.cafe.adapter.PayViewPagerAdapter
import com.example.hyoja.databinding.ActivityPayBinding

class PayActivity : AppCompatActivity() {
    lateinit var binding: ActivityPayBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewPager.adapter = PayViewPagerAdapter(this)
    }
}