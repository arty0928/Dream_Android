package com.dream.hyoja.cafe.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.dream.hyoja.R
import com.dream.hyoja.databinding.ActivityCafeStartExplainBinding

class CafeStartExplain : AppCompatActivity() {
    lateinit var binding: ActivityCafeStartExplainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCafeStartExplainBinding.inflate(layoutInflater)

        val anim = AnimationUtils.loadAnimation(this,R.anim.blink)
        binding.forHere.startAnimation(anim)

        setContentView(binding.root)
    }
}