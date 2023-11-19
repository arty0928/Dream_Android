package com.example.hyoja.cafe.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.OrderingDrink
import com.example.hyoja.cafe.util.ApplyOrderList
import com.example.hyoja.databinding.OrderedListItemBinding

class OrderedListAdapter: RecyclerView.Adapter<OrderedListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder =
        ViewHolder(OrderedListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = CafeModel.drinkSelectedList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 이미지
        holder.drinkImage.setImageResource(CafeModel.drinkSelectedList[position].drink.drinkImage)
        // 음료 개수
        holder.count.text = CafeModel.drinkSelectedList[position].drinkCount.toString()

        holder.itemPlus.setOnClickListener{
            CafeModel.drinkSelectedList[position].drinkCount++
            holder.setDrinkCount(position)
            holder.setPrice()
        }
        holder.itemMinus.setOnClickListener{
            CafeModel.drinkSelectedList[position].drinkCount --
            holder.setDrinkCount(position)
            holder.setPrice()
        }

        holder.cancelButton.setOnClickListener {
            CafeModel.drinkSelectedList.removeAt(position)
            holder.setPrice()
        }
    }
    class ViewHolder(itemView: OrderedListItemBinding):RecyclerView.ViewHolder(itemView.root){
        val binding = itemView
        val drinkImage = binding.drinkImage
        val itemPlus = binding.itemPlus
        val itemMinus = binding.itemMinus
        val count = binding.itemNum
        val cancelButton = binding.cancelButton

        fun setDrinkCount(position: Int){
            var orderingDrink = CafeModel.drinkSelectedList[position]
            orderingDrink.price = (orderingDrink.drink.price + 500 * orderingDrink.size) * orderingDrink.drinkCount
            count.text = CafeModel.drinkSelectedList[position].drinkCount.toString()
        }

        fun setPrice(){
            ApplyOrderList(CafeModel.currentActivity).drinkPriceSet()
        }
    }
}