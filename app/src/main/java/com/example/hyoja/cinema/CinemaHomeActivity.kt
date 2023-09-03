package com.example.hyoja.cinema

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.databinding.ActivityCinemaHomeBinding

class CinemaHomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCinemaHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCinemaHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}