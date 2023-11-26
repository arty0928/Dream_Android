package com.dream.hyoja.Fragments

import android.content.Intent
import android.graphics.Point
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.FragmentPay2Binding
import com.dream.hyoja.fastfoods.FastFoodPayWait
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

class PayFragment : DialogFragment() {
    private val Tag: String = "checkCancelFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentPay2Binding
    lateinit var viewModel: FoodListViewModel
    val common = CommonUi()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentPay2Binding.inflate(inflater, container, false)

        Log.d(Tag,"onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view = this

        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]

        // 2초 후에 화면에서 제거되도록 핸들러를 사용합니다.
        Handler(Looper.getMainLooper()).postDelayed({
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()

            // FragmentPay2Binding이 사라진 후에 FastFoodPayWait 액티비티 실행
            val intent = Intent(requireContext(), FastFoodPayWait::class.java)
            startActivity(intent)

        }, 3000)
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.85).toInt(), (height * 0.85).toInt())
        window?.setGravity(Gravity.CENTER)
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}
