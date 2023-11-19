package com.example.hyoja.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hyoja.databinding.FragmentFoodAddedBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FoodAddedFragment : Fragment() {
    private val Tag: String = "FoodAddedFragment"
    lateinit var binding: FragmentFoodAddedBinding
    lateinit var viewModel: FoodListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // ViewBinding을 초기화하고 레이아웃을 반환합니다.
        binding = FragmentFoodAddedBinding.inflate(inflater, container, false)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // FoodOrderedListAdapter를 생성할 때 ItemClickListener를 전달

        binding.plusItem.setOnClickListener {
        }
        binding.miusItem.setOnClickListener {

        }
        binding.selectItemDelete.setOnClickListener {
            FastFoodModel.foodSelectedList
        }

    }

}
