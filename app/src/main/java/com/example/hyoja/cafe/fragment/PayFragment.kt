package com.example.hyoja.cafe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hyoja.R
import com.example.hyoja.cafe.adapter.PayRecyclerViewAdapter
import com.example.hyoja.cafe.util.DrinkDataFactory
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding
import com.example.hyoja.databinding.FragmentPayBinding

class PayFragment : DialogFragment() {
    var binding: FragmentPayBinding? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentPayBinding.inflate(inflater, container, false)
        binding!!.list.layoutManager = LinearLayoutManager(context)
        binding!!.list.adapter = PayRecyclerViewAdapter()


        return binding!!.root
    }
}