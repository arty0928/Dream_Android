package com.example.hyoja.Fragments

import android.graphics.Point
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.hyoja.databinding.FragmentSetOrOnlyBinding

class SetOrOnlyFragment : DialogFragment() {
    private val Tag: String = "SetOrOnlyDialogFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentSetOrOnlyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentSetOrOnlyBinding.inflate(inflater, container, false)

        binding.dialogXButton.setOnClickListener {
            dismiss() // Dialog를 닫는 메서드
        }

        binding.optionOnlyBurger.setOnClickListener {
            dismiss()
        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 이제 binding을 사용하여 UI 요소에 접근할 수 있습니다.
        // 예를 들어, binding.textView.text = "안녕하세요"와 같은 방식으로 UI 요소를 조작할 수 있습니다.
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.85).toInt(), (height * 0.25).toInt())
        window?.setGravity(Gravity.CENTER)
    }
    override fun onDestroyView() {
        super.onDestroyView()

    }
}
