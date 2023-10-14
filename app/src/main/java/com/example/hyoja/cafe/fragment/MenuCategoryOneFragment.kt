package com.example.hyoja.cafe.fragment

import android.annotation.SuppressLint
import android.app.Application
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentMenuCategoryOneBinding


class MenuCategoryOneFragment : Fragment() {
    private lateinit var viewModel: MenuListViewModel
    private val Tag:String ="MenuCategoryOneFragment"

    lateinit var binding: FragmentMenuCategoryOneBinding
    interface OnButtonClickListener {
        fun onButtonClicked(count: Int)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //메뉴리스트 뷰모델
        viewModel = ViewModelProvider(requireActivity())[MenuListViewModel::class.java]
        viewModel.categoryLiveData.observe(viewLifecycleOwner, Observer {
            resetButtons()
            when(it){
                "newMenu" -> {
                    binding.newMenuButton.setBackgroundResource(R.drawable.button_round)
                    binding.newMenuButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))}
                "ade" -> {
                    binding.adeButton.setBackgroundResource(R.drawable.button_round)
                    binding.adeButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
                }
                "shake" -> {
                    binding.shakeButton.setBackgroundResource(R.drawable.button_round)
                    binding.shakeButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
                }
                "coffee" -> {
                    binding.coffeeButton.setBackgroundResource(R.drawable.button_round)
                    binding.coffeeButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
                }
            }
        })
    }


    override fun onResume() {
        super.onResume()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuCategoryOneBinding.inflate(inflater,container,false)

        binding.newMenuButton.setOnClickListener{
            CafeModel.menuCategory = "newMenu"
            Log.d(Tag,"menuCategory = "+CafeModel.menuCategory)
            viewModel.dataChanged()
        }
        binding.adeButton.setOnClickListener {
            CafeModel.menuCategory = "ade"
            Log.d(Tag,"menuCategory = "+CafeModel.menuCategory)
            viewModel.dataChanged()
        }
        binding.coffeeButton.setOnClickListener {
            CafeModel.menuCategory = "coffee"
            Log.d(Tag,"menuCategory = "+CafeModel.menuCategory)
            viewModel.dataChanged()
        }
        binding.shakeButton.setOnClickListener {
            CafeModel.menuCategory = "shake"
            Log.d(Tag,"menuCategory = "+CafeModel.menuCategory)
            viewModel.dataChanged()
        }
        return binding.root
    }
    private fun resetButtons() {
        binding.newMenuButton.setBackgroundResource(R.drawable.round_button)
        binding.newMenuButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        binding.adeButton.setBackgroundResource(R.drawable.round_button)
        binding.adeButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        binding.coffeeButton.setBackgroundResource(R.drawable.round_button)
        binding.coffeeButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        binding.shakeButton.setBackgroundResource(R.drawable.round_button)
        binding.shakeButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        Log.d(Tag,"resetButtonsCall")
    }


}
