package com.example.hyoja.cafe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.hyoja.R
import com.example.hyoja.databinding.FragmentSavingPointBinding

class SavingPointFragment : Fragment() {
    lateinit var binding: FragmentSavingPointBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSavingPointBinding.inflate(layoutInflater)

        binding.card.setOnClickListener {
            binding.card.setBackgroundResource(R.drawable.hot_button_unclicked)
        }

        binding.mobile.setOnClickListener {
            Toast.makeText(context,"아직 지원하지 않습니다.",Toast.LENGTH_SHORT).show()
        }
        binding.coupon.setOnClickListener {
            Toast.makeText(context,"아직 지원하지 않습니다.",Toast.LENGTH_SHORT).show()
        }
        binding.gift.setOnClickListener {
            Toast.makeText(context,"아직 지원하지 않습니다.",Toast.LENGTH_SHORT).show()
        }

        return binding.root
    }
}