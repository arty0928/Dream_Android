package com.dream.hyoja.fastfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.ActivityFastfoodHomeBinding

class FastFoodHomeActivity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityFastfoodHomeBinding
    val common = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.fastfoodToHome1Button.setOnClickListener{
            common.goToFastFoodHome1(view)
        }
    }
}