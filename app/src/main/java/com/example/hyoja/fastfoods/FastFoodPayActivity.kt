package com.example.hyoja.fastfoods

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hyoja.Fragments.checkCancelFragment
import com.example.hyoja.cafe.adapter.TotalFoodListAdapter
import com.example.hyoja.common.util.CommonUi
import com.example.hyoja.databinding.ActivityFastfoodPayBinding
import com.example.hyoja.fastfoods.model.FastFoodModel
import com.example.hyoja.fastfoods.viewmodel.FoodListViewModel

class FastFoodPayActivity : AppCompatActivity() {
    var backPressedTime: Long = 0 // 뒤로가기 2번 클릭을 위한 변수선언
    private val Tag:String = "FastFoodPayActivity"

    private lateinit var viewModel: FoodListViewModel

    private lateinit var binding: ActivityFastfoodPayBinding
    val common = CommonUi()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFastfoodPayBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val view = this

        binding.cancelButton.setOnClickListener {
            checkCancelFragment().show(
                supportFragmentManager, "checkCancelFragment"
            )
        }
        binding.payTotalPrice.text = FastFoodModel.priceToPay.toString()
        binding.haveToPayPrice.text = FastFoodModel.priceToPay.toString()

        totalFoodListAdded()
    }

    fun totalFoodListAdded(){
        binding.FoodSelectedList.layoutManager = LinearLayoutManager(this).also {
            it.orientation = LinearLayoutManager.VERTICAL
        }

        Log.d(Tag,"totalFoodListAdded called")

        binding.FoodSelectedList.adapter = TotalFoodListAdapter(binding)
    }

}