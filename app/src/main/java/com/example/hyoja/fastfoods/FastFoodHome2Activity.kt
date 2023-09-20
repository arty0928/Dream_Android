package com.example.hyoja.fastfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodHome2Binding
class FastFoodHome2Activity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private lateinit var binding: ActivityFastfoodHome2Binding
    val common = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodHome2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this
    }
}
