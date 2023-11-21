package com.example.hyoja.cafe.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityCardBinding
import com.example.hyoja.databinding.ActivityCompletePayBinding

class CardActivity : AppCompatActivity() {
    private var backPressedTime: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image.setOnClickListener {
            val intent = Intent(this, CompletePayActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        val currentTime = System.currentTimeMillis()
        val commonUi: CommonUi = CommonUi()
        val view = this

        if (currentTime - backPressedTime < 2000) {
            commonUi.goToHome(view)
            finish()
        } else {
            Toast.makeText(this, "한 번 더 누르면 메인화면으로 전환합니다", Toast.LENGTH_SHORT).show()
            backPressedTime = currentTime
        }
    }
}