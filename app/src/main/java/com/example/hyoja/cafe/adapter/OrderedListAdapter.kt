package com.example.hyoja.cafe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.databinding.OrderedListItemBinding

class OrderedListAdapter: RecyclerView.Adapter<OrderedListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(OrderedListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = CafeModel.drinkSelectedList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 이미지
        holder.drinkImage.setImageResource(CafeModel.drinkSelectedList[position].drink.drinkImage)
        // 음료 개수
        holder.count.text = CafeModel.drinkSelectedList[position].drinkCount.toString()
    }
    class ViewHolder(itemView: OrderedListItemBinding):RecyclerView.ViewHolder(itemView.root){
        val binding = itemView
        val drinkImage = binding.drinkImage
        val itemPlus = binding.itemPlus
        val itemMinus = binding.itemMinus
        val count = binding.itemNum

    }
}