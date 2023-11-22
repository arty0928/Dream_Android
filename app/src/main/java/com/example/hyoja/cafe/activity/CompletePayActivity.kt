package com.example.hyoja.cafe.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.R
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityCafeHome1Binding
import com.example.hyoja.databinding.ActivityCompletePayBinding

class CompletePayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityCompletePayBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.image.setOnClickListener{
            CommonUi().goToCafe(this)
        }

    }
}