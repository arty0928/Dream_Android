package com.dream.hyoja.common

import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.cafe.model.CafeModel
import com.dream.hyoja.cafe.util.ApplyOrderList
import com.dream.hyoja.cafe.viewmodel.MenuListViewModel
import com.dream.hyoja.databinding.FragmentDrinkOrderAddBinding
import com.dream.hyoja.databinding.ManualBinding

class ManualDialog: DialogFragment() {
    lateinit var binding: ManualBinding
    private var msg = " "
    private var btn = " "
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        binding.button.setOnClickListener {
            requireActivity().supportFragmentManager.beginTransaction().remove(this).commit()
            requireActivity().supportFragmentManager.popBackStack()
        }

        if (msg != " "){
            binding.message.text = msg
        }

        if (btn != " "){
            binding.button.text = btn
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ManualBinding.inflate(inflater, container, false)
        val view = binding.root

        return view
    }

    override fun onResume() {
        super.onResume()
        val window: Window? = dialog?.window
        val size = Point()
        val display = window?.windowManager?.defaultDisplay
        display?.getSize(size)
        val width = size.x
        val height = size.y
        window?.setLayout((width * 0.9).toInt(), (height * 0.9).toInt())
        window?.setGravity(Gravity.CENTER)
    }

    fun setText(msg: String){
        this.msg = msg
    }

    fun setButton(btn: String){
        this.btn = btn
    }
}