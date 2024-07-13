package com.dream.hyoja.cafe.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityCardBinding

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
        super.onBackPressed()
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