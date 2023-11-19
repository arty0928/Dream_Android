package com.example.hyoja.cafe.fragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.hyoja.R
import com.example.hyoja.cafe.model.OrderingDrink
import com.example.hyoja.databinding.FragmentOptionAddBinding

class OptionAddFragment: DialogFragment(), OptionAddInterface {
    lateinit var binding: FragmentOptionAddBinding
    private lateinit var orderingDrink: OrderingDrink
    private var info: Boolean = true
    private lateinit var parentFragment: DrinkOrderAddDialogFragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var shotStatus: Boolean

        // 현재 추가된 상태인지 체크
        if (shotStatus(orderingDrink)){
            clickedUI(requireContext(), binding.shotAdd)
            shotStatus = true
        }
        else{
            unClickedUI(requireContext(), binding.shotAdd)
            shotStatus = false
        }

        // 샷 추가
        binding.shotAdd.setOnClickListener {
            // 현재 상태가 추가된 상태인지 체크
            if (shotStatus){
                unClickedUI(requireContext(), binding.shotAdd)
                shotStatus = false
            }
            else{
                clickedUI(requireContext(), binding.shotAdd)
                shotStatus = true
            }
            Log.d("orderingDrink Check",orderingDrink.option.toString())
        }

        // 완료
        binding.complete.setOnClickListener {
            complete(orderingDrink, shotStatus)
            dismiss()
        }

        // 취소
        binding.cancel.setOnClickListener {
            dismiss()
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?{
        binding = FragmentOptionAddBinding.inflate(inflater, container, false)

        return binding!!.root
    }

    fun setOrderingDrink(orderingDrink: OrderingDrink){
        this.orderingDrink = orderingDrink
    }

    fun setParentFragment(fragment: DrinkOrderAddDialogFragment){
        
    }

}
interface OptionAddInterface {
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

    fun complete(orderingDrink: OrderingDrink, shotStatus: Boolean){
        if (shotStatus)
            addOption(orderingDrink, "shot")
        else
            deleteOption(orderingDrink, "shot")
    }

    fun addOption(orderingDrink: OrderingDrink, option: String) {
        // 미리 이미 옵션이 추가되어있는지 확인
        var exist: Boolean = false
        for (i in 0 until orderingDrink.option.size) {
            when (orderingDrink.option[i]) {
                option -> {
                    exist = true
                }
            }
        }
        // 없으면 추가, 있으면 추가안해도 됨.
        if (!exist) {
            when (option) {
                "shot" -> {
                    orderingDrink.option.add("shot")
                    orderingDrink.shot = 1
                }
                "ice" -> orderingDrink.option.add("ice")
                "syrup" -> orderingDrink.option.add("syrup")
            }
        }
    }

    fun deleteOption(orderingDrink: OrderingDrink, option: String): OrderingDrink{
        for(i in 0 until orderingDrink.option.size){
            when(orderingDrink.option[i]){
                option -> {
                    orderingDrink.option.removeAt(i)
                    orderingDrink.shot = 0
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