package com.example.hyoja.cafe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hyoja.R
import com.example.hyoja.cafe.adapter.PayRecyclerViewAdapter
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.util.DrinkDataFactory
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding
import com.example.hyoja.databinding.FragmentPayBinding

class PayFragment : Fragment() {
    lateinit var binding: FragmentPayBinding
    lateinit var adapter: FragmentStateAdapter
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CafeModel.FragmentStatus = this


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentPayBinding.inflate(inflater, container, false)
        binding.list.layoutManager = LinearLayoutManager(context)
        binding.list.adapter = PayRecyclerViewAdapter()

        return binding.root
    }

    interface NextListener{
        fun setNextItem()
    }
}