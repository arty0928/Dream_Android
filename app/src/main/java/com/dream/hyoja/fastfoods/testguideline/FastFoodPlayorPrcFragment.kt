package com.dream.hyoja.fastfoods.testguideline

import android.graphics.Point
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.dream.hyoja.common.util.CommonUi
import com.dream.hyoja.databinding.FragmentFastfoodPlayOrTestBinding

class FastFoodPlayorPrcFragment : DialogFragment() {
    private val Tag: String = "FastFoodPlayorTestFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentFastfoodPlayOrTestBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentFastfoodPlayOrTestBinding.inflate(inflater, container, false)

        binding.FastfoodPrcMode.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
            CommonUi().goToPrcFastFood(requireActivity())
        }


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.9).toInt(), (height * 0.3).toInt())
        window?.setGravity(Gravity.CENTER)
    }
    override fun onDestroyView() {
        super.onDestroyView()

    }
}
