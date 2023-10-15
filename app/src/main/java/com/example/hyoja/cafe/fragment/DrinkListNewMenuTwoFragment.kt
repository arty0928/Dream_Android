package com.example.hyoja.cafe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hyoja.R
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding
import com.example.hyoja.databinding.FragmentDrinkListNewMenuTwoBinding

class DrinkListNewMenuTwoFragment : Fragment() {
    lateinit var binding: FragmentDrinkListNewMenuTwoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkListNewMenuTwoBinding.inflate(inflater, container, false)

        return binding.root
    }

}