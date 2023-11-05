package com.example.hyoja.Fragments

import android.graphics.Point
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import com.example.hyoja.databinding.FragmentChoiceSetMenuDialogBinding
import com.example.hyoja.fastfoods.adapter.SetMenuChoiceCategoryAdapter
import com.example.hyoja.fastfoods.adapter.SetMenuChoiceMainViewPagerAdapter

class ChoiceSetMenuDialogFragment : DialogFragment() {
    private val Tag: String = "SetOrOnlyDialogFragment"

    // ViewBinding을 초기화합니다.
    private lateinit var binding: FragmentChoiceSetMenuDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentChoiceSetMenuDialogBinding.inflate(inflater, container, false)

        val parentFragment = parentFragmentManager?.findFragmentByTag("SetOrOnlyFragment") as DialogFragment?
        parentFragment?.dismiss()
    
        //카테고리 뷰페이저
        binding.SetMenuChoiceCategory.adapter = SetMenuChoiceCategoryAdapter(this)
        binding.SetMenuChoiceCategory.isUserInputEnabled = false;

        binding.SetMenuChoiceMainViewPager.adapter = SetMenuChoiceMainViewPagerAdapter(this)
        binding.SetMenuChoiceMainViewPager.isUserInputEnabled = false;

        binding.cancelButton.setOnClickListener {
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
        window?.setLayout((width * 0.9).toInt(), (height * 0.85).toInt())
        window?.setGravity(Gravity.CENTER)
    }
    override fun onDestroyView() {
        super.onDestroyView()

    }
}
