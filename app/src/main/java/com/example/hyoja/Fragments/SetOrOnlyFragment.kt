package com.example.hyoja.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 이제 binding을 사용하여 UI 요소에 접근할 수 있습니다.
        // 예를 들어, binding.textView.text = "안녕하세요"와 같은 방식으로 UI 요소를 조작할 수 있습니다.
    }
}
