package com.example.hyoja.fastfoods

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hyoja.Fragments.FastFoodStep3Fragment
import com.example.hyoja.Fragments.checkCancelFragment
import com.example.hyoja.R
import com.example.hyoja.cafe.adapter.TotalFoodListAdapter
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodPayBinding
import com.example.hyoja.databinding.ActivityPayWaitBinding
import com.example.hyoja.databinding.FragmentFastFoodStep3Binding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.model.PayStep
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FastFoodPayWait : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private val Tag:String = "FastFoodPayWait"

    private lateinit var viewModel: FoodListViewModel

    private lateinit var binding: ActivityPayWaitBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPayWaitBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this
        val common = CommonUi()

        // 오른쪽에서 왼쪽으로 이동하는 애니메이션 적용
        binding.root.translationX = binding.root.width.toFloat()
        binding.root.animate()
            .translationX(0f)
            .setDuration(1000)
            .start()

        // 3초 후에 화면이 사라지도록 핸들러를 사용
        Handler(Looper.getMainLooper()).postDelayed({
            // binding이 사라진 후에 common.goToHome으로 이동
            common.goToHome(this)
        }, 3000)

    }

}