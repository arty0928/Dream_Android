package com.example.hyoja.cafe.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.hyoja.R
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.viewmodel.MenuListViewModel
import com.example.hyoja.databinding.FragmentMenuCategoryOneBinding
import com.example.hyoja.databinding.FragmentMenuCategoryTwoBinding

class MenuCategoryTwoFragment : Fragment() {
    private lateinit var viewModel: MenuListViewModel
    private val Tag:String ="MenuCategoryTwoFragment"
    lateinit var binding: FragmentMenuCategoryTwoBinding

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
                "tea" -> {
                    binding.teaButton.setBackgroundResource(R.drawable.button_round)
                    binding.teaButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
                }
                "flatccino" -> {
                    binding.flatccinoButton.setBackgroundResource(R.drawable.button_round)
                    binding.flatccinoButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
                }
                "baverage" -> {
                    binding.baverageButton.setBackgroundResource(R.drawable.button_round)
                    binding.baverageButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
                }
                "bubbleMilk" -> {
                    binding.bubbleMilkButton.setBackgroundResource(R.drawable.button_round)
                    binding.bubbleMilkButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
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
        binding = FragmentMenuCategoryTwoBinding.inflate(inflater,container,false)

        binding.baverageButton.setOnClickListener{
            CafeModel.menuCategory = "baverage"
            Log.d(Tag,"menuCategory = "+ CafeModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.flatccinoButton.setOnClickListener {
            CafeModel.menuCategory = "flatccino"
            Log.d(Tag,"menuCategory = "+ CafeModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.teaButton.setOnClickListener {
            CafeModel.menuCategory = "tea"
            Log.d(Tag,"menuCategory = "+ CafeModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.bubbleMilkButton.setOnClickListener {
            CafeModel.menuCategory = "bubbleMilk"
            Log.d(Tag,"menuCategory = "+ CafeModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        return binding.root
    }
    private fun resetButtons() {
        binding.bubbleMilkButton.setBackgroundResource(R.drawable.round_button)
        binding.bubbleMilkButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        binding.teaButton.setBackgroundResource(R.drawable.round_button)
        binding.teaButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        binding.flatccinoButton.setBackgroundResource(R.drawable.round_button)
        binding.flatccinoButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        binding.baverageButton.setBackgroundResource(R.drawable.round_button)
        binding.baverageButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_black))
        Log.d(Tag,"resetButtonsCall")
    }
}