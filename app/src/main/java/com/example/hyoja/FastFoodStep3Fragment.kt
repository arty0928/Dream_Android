package com.example.hyoja.Fragments

import android.graphics.Point
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.FragmentCheckCancelBinding
import com.example.hyoja.databinding.FragmentFastFoodStep3Binding
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FastFoodStep3Fragment : DialogFragment() {
    private val Tag: String = "checkCancelFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentFastFoodStep3Binding
    lateinit var viewModel: FoodListViewModel
    val common = CommonUi()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentFastFoodStep3Binding.inflate(inflater, container, false)

        Log.d(Tag,"onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view = this

        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]

        binding.payCancelBtn.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
        }
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.85).toInt(), (height * 0.8).toInt())
        window?.setGravity(Gravity.CENTER)
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}
