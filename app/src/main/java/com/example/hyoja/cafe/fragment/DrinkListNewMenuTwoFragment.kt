package com.example.hyoja.cafe.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.NewMenu1
import com.example.hyoja.cafe.model.NewMenu2
import com.example.hyoja.cafe.model.NewMenu3
import com.example.hyoja.cafe.model.NewMenu4
import com.example.hyoja.cafe.model.NewMenu5
import com.example.hyoja.cafe.model.NewMenu6
import com.example.hyoja.cafe.model.NewMenu7
import com.example.hyoja.cafe.model.NewMenu8
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentDrinkListNewMenuOneBinding
import com.example.hyoja.databinding.FragmentDrinkListNewMenuTwoBinding

class DrinkListNewMenuTwoFragment : Fragment() {
    lateinit var binding: FragmentDrinkListNewMenuTwoBinding
    private lateinit var viewModel: MenuListViewModel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val Tag:String = "DrinkListNewMenuTwoFragment"
        viewModel = ViewModelProvider(requireActivity())[MenuListViewModel::class.java]
        binding.newMenu5.setOnClickListener{
            CafeModel.drinkSelected = "newMenu5"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
        binding.newMenu6.setOnClickListener{
            CafeModel.drinkSelected = "newMenu6"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
        binding.newMenu7.setOnClickListener{
            CafeModel.drinkSelected = "newMenu7"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
        binding.newMenu8.setOnClickListener{
            CafeModel.drinkSelected = "newMenu8"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+ CafeModel.drinkSelected)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkListNewMenuTwoBinding.inflate(inflater, container, false)
        binding.newMenu5Price.text = NewMenu5().price.toString()
        binding.newMenu6Price.text = NewMenu6().price.toString()
        binding.newMenu7Price.text = NewMenu7().price.toString()
        binding.newMenu8Price.text = NewMenu8().price.toString()

        return binding.root
    }

}