package com.dream.hyoja.cafe.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dream.hyoja.cafe.model.CafeModel
import com.dream.hyoja.cafe.util.ApplyOrderList
import com.dream.hyoja.databinding.OrderedListItemBinding

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
            if (CafeModel.drinkSelectedList[position].drinkCount > 0) {
                CafeModel.drinkSelectedList[position].drinkCount--
                holder.setDrinkCount(position)
                holder.setPrice()
            }
        }

        holder.cancelButton.setOnClickListener {
            this.notifyDataSetChanged()
            holder.deleteItem()
            Log.d("  ",CafeModel.drinkSelectedList.toString())
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

        fun deleteItem(){
            Log.d("selectedPosition = ", position.toString())
            Log.d("selectedItem = ", CafeModel.drinkSelectedList[position].drink.name)
            CafeModel.drinkSelectedList.removeAt(position)
        }

        fun setUi(){
            drinkImage.setImageResource(CafeModel.drinkSelectedList[position].drink.drinkImage)
            count.text = CafeModel.drinkSelectedList[position].drinkCount.toString()
        }

        fun setDrinkCount(position: Int){
            var orderingDrink = CafeModel.drinkSelectedList[position]
            orderingDrink.price = (orderingDrink.shot*500 + orderingDrink.drink.price + 500 * orderingDrink.size) * orderingDrink.drinkCount
            count.text = CafeModel.drinkSelectedList[position].drinkCount.toString()
        }

        fun setPrice(){
            ApplyOrderList(CafeModel.currentActivity).drinkPriceSet()
        }
    }
}