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
            CafeModel.drinkSelected = "drink1"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu2.setOnClickListener{
            CafeModel.drinkSelected = "drink2"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu3.setOnClickListener{
            CafeModel.drinkSelected = "drink3"
            viewModel.drinkSelectChanged()
            Log.d(Tag,"drinkSelected= "+CafeModel.drinkSelected)
        }
        binding.newMenu4.setOnClickListener{
            CafeModel.drinkSelected = "drink4"
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
    fun setUI(){
        binding.menu1ImageView.setImageResource(drinkData5.drinkImage)
        binding.newMenu5Name.text = drinkData5.name
        binding.newMenu5Price.text = drinkData5.price.toString()

        binding.newMenu6Image.setImageResource(drinkData6.drinkImage)
        binding.newMenu6Name.text = drinkData6.name
        binding.newMenu6Price.text = drinkData6.price.toString()

        binding.newMenu7Image.setImageResource(drinkData7.drinkImage)
        binding.newMenu7Name.text = drinkData7.name
        binding.newMenu7Price.text = drinkData7.price.toString()

        binding.newMenu8Image.setImageResource(drinkData8.drinkImage)
        binding.newMenu8Name.text = drinkData8.name
        binding.newMenu8Price.text = drinkData8.price.toString()
    }



}