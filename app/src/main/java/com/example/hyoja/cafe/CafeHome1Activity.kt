package com.example.hyoja.cafe

import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.WindowManager
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import com.example.hyoja.R
import com.example.hyoja.databinding.ActivityCafeHome1Binding


class CafeHome1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityCafeHome1Binding
    private var coffeePopup: PopupWindow? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCafeHome1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            coffeePopup?.dismiss()
        }

        binding.button2.setOnClickListener {
            coffeePopup?.dismiss()
        }

        binding.button3.setOnClickListener {
            if (coffeePopup?.isShowing != true) {
                showCoffeePopup()
            }
        }

        binding.button4.setOnClickListener {
            coffeePopup?.dismiss()
        }
    }

    private fun showCoffeePopup() {
        if (coffeePopup == null) {
            val inflater = getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.popup_coffee_layout, null)

            val width = (resources.displayMetrics.widthPixels * 0.96).toInt()
            val height = WindowManager.LayoutParams.WRAP_CONTENT

            coffeePopup = PopupWindow(popupView, width, height).apply {
                isOutsideTouchable = false
                isFocusable = true

                setOnDismissListener {

                }

            }
        }

        val location = IntArray(2)
        binding.button4.getLocationOnScreen(location)
        val yOffset = (3 * resources.displayMetrics.density).toInt()
        val y = location[1] + binding.button4.height + yOffset

        val x = (resources.displayMetrics.widthPixels - coffeePopup!!.width) / 2
        coffeePopup?.showAtLocation(binding.root, Gravity.NO_GRAVITY, x, y)
    }

    override fun onDestroy() {
        coffeePopup?.dismiss()
        super.onDestroy()
    }
}
