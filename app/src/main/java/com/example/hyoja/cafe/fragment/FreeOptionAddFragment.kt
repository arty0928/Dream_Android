package com.example.hyoja.cafe.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import com.example.hyoja.R
import com.example.hyoja.cafe.model.OrderingDrink
import com.example.hyoja.databinding.FragmentFreeOptionAddBinding
import com.example.hyoja.databinding.FragmentOptionAddBinding

class FreeOptionAddFragment: DialogFragment(), FreeOptionAddInterface {
    lateinit var binding: FragmentFreeOptionAddBinding
    private lateinit var orderingDrink: OrderingDrink
    private var info: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 얼음 추가
        binding.iceAdd.setOnClickListener {
            if (iceStatus(orderingDrink)){
                unClickedUI(requireContext(), binding.iceAdd)
                orderingDrink = deleteOption(orderingDrink,"ice")
            }
            else{
                clickedUI(requireContext(), binding.iceAdd)
                orderingDrink = addOption(orderingDrink,"ice")
            }
            Log.d("orderingDrink Check",orderingDrink.option.toString())
        }

        // 시럽 추가
        binding.syrupAdd.setOnClickListener {
            if (syrupStatus(orderingDrink)){
                unClickedUI(requireContext(), binding.syrupAdd)
                orderingDrink = deleteOption(orderingDrink,"syrup")
            }
            else{
                clickedUI(requireContext(), binding.syrupAdd)
                orderingDrink = addOption(orderingDrink,"syrup")
            }
            Log.d("orderingDrink Check",orderingDrink.option.toString())
        }

        // 완료
        binding.complete.setOnClickListener {
            onDestroyView()
        }

        // 취소
        binding.cancel.setOnClickListener {
            onDestroyView()
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentFreeOptionAddBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    fun setOrderingDrink(orderingDrink: OrderingDrink){
        this.orderingDrink = orderingDrink
    }

}
interface FreeOptionAddInterface {
    val clickedButton: Int
        get() = R.drawable.hot_button_clicked
    @get:ColorRes
    val clickedButtonTextColor: Int
        get()= R.color.white
    val unClickedButton: Int
        get() = R.drawable.hot_button_unclicked
    @get:ColorRes
    val unClickedButtonTextColor:Int
        get() = R.color.cafe_darkRed

    fun clickedUI(context: Context, button: TextView){
        button.setBackgroundResource(clickedButton)
        button.setTextColor(ContextCompat.getColor(context, clickedButtonTextColor))
    }
    fun unClickedUI(context: Context, button: TextView){
        button.setBackgroundResource(unClickedButton)
        button.setTextColor(ContextCompat.getColor(context, unClickedButtonTextColor))
    }

    fun addOption(orderingDrink: OrderingDrink, option: String): OrderingDrink{
        when(option){
            "shot" -> orderingDrink.option.add("shot")
            "ice" -> orderingDrink.option.add("ice")
            "syrup" -> orderingDrink.option.add("syrup")
        }
        return orderingDrink
    }

    fun deleteOption(orderingDrink: OrderingDrink, option: String): OrderingDrink{
        for(i in 0 until orderingDrink.option.size){
            when(orderingDrink.option[i]){
                option -> {
                    orderingDrink.option.removeAt(i)
                    return orderingDrink
                }
            }
        }
        return orderingDrink
    }

    fun shotStatus(orderingDrink: OrderingDrink): Boolean{
        val size = orderingDrink.option.size
        var shot: Boolean = false

        for(i in 0 until size){
            when(orderingDrink.option[i]){
                "shot" -> return true
            }
        }
        return false
    }
    fun iceStatus(orderingDrink: OrderingDrink): Boolean{
        val size = orderingDrink.option.size
        var ice: Boolean = false

        for(i in 0 until size){
            when(orderingDrink.option[i]){
                "ice" -> return true
            }
        }
        return false
    }
    fun syrupStatus(orderingDrink: OrderingDrink): Boolean{
        val size = orderingDrink.option.size
        var syrup: Boolean = false

        for(i in 0 until size){
            when(orderingDrink.option[i]){
                "syrup" -> return true
            }
        }
        return false
    }
}