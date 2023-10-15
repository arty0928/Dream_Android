package com.example.hyoja.cafe.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.NewMenu1
import com.example.hyoja.cafe.model.NewMenu2
import com.example.hyoja.cafe.model.NewMenu3
import com.example.hyoja.cafe.model.NewMenu4
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding

class DrinkListNewMenuOneFragment : Fragment() {
    private val Tag: String = "DrinkListNewMenuOneFragment"
    lateinit var binding: FragmentDrinkListNewMenuOneBinding
    private lateinit var viewModel: MenuListViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //뷰모델 프로바이더 생성
        viewModel = ViewModelProvider(requireActivity())[MenuListViewModel::class.java]

        binding.newMenu1.setOnClickListener{
            CafeModel.drinkSelected = "newMenu1"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu2.setOnClickListener{
            CafeModel.drinkSelected = "newMenu2"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu3.setOnClickListener{
            CafeModel.drinkSelected = "newMenu3"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu4.setOnClickListener{
            CafeModel.drinkSelected = "newMenu4"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkListNewMenuOneBinding.inflate(inflater, container, false)
        binding.newMenu1Price.text = NewMenu1().price.toString()
        binding.newMenu2Price.text = NewMenu2().price.toString()
        binding.newMenu3Price.text = NewMenu3().price.toString()
        binding.newMenu4Price.text = NewMenu4().price.toString()

        return binding.root
    }



}