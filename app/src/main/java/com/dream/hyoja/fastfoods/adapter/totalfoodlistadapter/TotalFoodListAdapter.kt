package com.dream.hyoja.cafe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dream.hyoja.databinding.ActivityFastfoodPayBinding
import com.dream.hyoja.databinding.FragmentPayOrderedListBinding
import com.dream.hyoja.fastfoods.model.FastFoodModel

class TotalFoodListAdapter(binding: ActivityFastfoodPayBinding) : RecyclerView.Adapter<TotalFoodListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(FragmentPayOrderedListBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.payOrderedFoodName.text = FastFoodModel.foodSelectedList[position].food.name
        if(FastFoodModel.foodSelectedList[position].setDessert ==null && FastFoodModel.foodSelectedList[position].setDrink == null){
            holder.binding.paySetIcon.visibility = View.INVISIBLE
        }
        holder.binding.payOrderedFoodPrice.text = FastFoodModel.foodSelectedList[position].totalPrice.toString()
        holder.binding.payOrderedFoodCount.text = FastFoodModel.foodSelectedList[position].foodCount.toString()

    }

    override fun getItemCount(): Int = FastFoodModel.foodSelectedList.size

    class ViewHolder(itemView: FragmentPayOrderedListBinding):RecyclerView.ViewHolder(itemView.root){
        val binding = itemView

    }
}