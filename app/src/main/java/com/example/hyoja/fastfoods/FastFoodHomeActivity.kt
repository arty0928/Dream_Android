package com.example.hyoja.fastfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.databinding.ActivityFastfoodHomeBinding

class FastFoodHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFastfoodHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}