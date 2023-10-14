package com.example.hyoja.cafe

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.Menu
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.adapter.MenuCategoryAdapter
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.ActivityCafeHome1Binding


class CafeHome1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCafeHome1Binding
    private var coffeePopup: PopupWindow? = null
    private lateinit var viewModel: MenuListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCafeHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        //카테고리 뷰페이저
        binding.menuList.adapter = MenuCategoryAdapter(this)
        var currentItem = binding.menuList.currentItem
        binding.menuList.isUserInputEnabled = false;

        //왼쪽 버튼
        binding.leftButton.setOnClickListener{
            if(currentItem == 1){
                currentItem = 0
                binding.menuList.setCurrentItem(0,true)
                binding.leftButton.setImageResource(R.drawable.left_arrow_white)
                binding.rightButton.setImageResource(R.drawable.right_arrow_red)
            }
        }

        //오른쪽 버튼
        binding.rightButton.setOnClickListener{
            if(currentItem == 0){
                currentItem = 1
                binding.menuList.setCurrentItem(1,true)
                binding.leftButton.setImageResource(R.drawable.left_arrow_red)
                binding.rightButton.setImageResource(R.drawable.right_arrow_white)
            }
        }
    }
}
