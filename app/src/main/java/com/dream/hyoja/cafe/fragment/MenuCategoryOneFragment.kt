package com.dream.hyoja.cafe.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.dream.hyoja.R
import com.dream.hyoja.cafe.model.CafeModel
import com.dream.hyoja.cafe.viewmodel.MenuListViewModel
import com.dream.hyoja.databinding.FragmentMenuCategoryOneBinding


class MenuCategoryOneFragment : Fragment() {
    private lateinit var viewModel: MenuListViewModel
    private val Tag:String ="MenuCategoryOneFragment"

    lateinit var binding: FragmentMenuCategoryOneBinding

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
                    binding.newMenuButton.setTextColor(ContextCompat.getColor(requireContext(),R.color.cafe_white))
                }
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
            viewModel.categorySelectChanged()
        }
        binding.adeButton.setOnClickListener {
            CafeModel.menuCategory = "ade"
            Log.d(Tag,"menuCategory = "+CafeModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.coffeeButton.setOnClickListener {
            CafeModel.menuCategory = "coffee"
            Log.d(Tag,"menuCategory = "+CafeModel.menuCategory)
            viewModel.categorySelectChanged()
        }
        binding.shakeButton.setOnClickListener {
            CafeModel.menuCategory = "shake"
            Log.d(Tag,"menuCategory = "+CafeModel.menuCategory)
            viewModel.categorySelectChanged()
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
