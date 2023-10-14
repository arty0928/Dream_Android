package com.example.hyoja.cafe.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding

class DrinkListNewMenuOneFragment : Fragment() {
    lateinit var binding: FragmentDrinkListNewMenuOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkListNewMenuOneBinding.inflate(inflater, container, false)


        return binding.root
    }

}