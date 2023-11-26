package com.dream.hyoja.Fragments

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
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.FragmentCheckCancelBinding
import com.dream.hyoja.fastfoods.viewmodel.FoodListViewModel

class checkCancelFragment : DialogFragment() {
    private val Tag: String = "checkCancelFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentCheckCancelBinding
    lateinit var viewModel: FoodListViewModel
    val common = CommonUi()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentCheckCancelBinding.inflate(inflater, container, false)

        Log.d(Tag,"onCreateView")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val view = this

        viewModel = ViewModelProvider(this)[FoodListViewModel::class.java]

        binding.cancelButtonYes.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
            view.context?.let { it1 -> common.goToFastFoodHome1(it1) }
        }

        binding.cancelButtonNo.setOnClickListener {
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
        window?.setLayout((width * 0.85).toInt(), (height * 0.3).toInt())
        window?.setGravity(Gravity.CENTER)
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}
