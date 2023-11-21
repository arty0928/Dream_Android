package com.example.hyoja.cafe.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyoja.Fragments.drink
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.cafe.model.OrderingDrink
import com.example.hyoja.databinding.FragmentPayBinding
import com.example.hyoja.databinding.OrderedListItemBinding
import com.example.hyoja.databinding.PayOrderedDrinksBinding

class PayRecyclerViewAdapter: RecyclerView.Adapter<PayRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(PayOrderedDrinksBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = CafeModel.drinkSelectedList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setUi()
    }
    class ViewHolder(itemView: PayOrderedDrinksBinding): RecyclerView.ViewHolder(itemView.root){
        val binding = itemView
        lateinit var drinkItem: OrderingDrink

        lateinit var size: String
        private var shot = ""
        private var syrup = ""
        private var ice = ""

        fun setUi(){
            var drinkItem = CafeModel.drinkSelectedList[position]
            this.drinkItem = drinkItem
            Log.d("position",position.toString())
            binding.drinkImage.setImageResource(drinkItem.drink.drinkImage)
            binding.itemNum.text = drinkItem.drinkCount.toString()
            binding.price.text = drinkItem.price.toString()
            binding.drinkPrice.text = (drinkItem.price/drinkItem.drinkCount).toString()
            binding.drinkCount.text = drinkItem.drinkCount.toString()
            binding.drinkName.text = drinkItem.drink.name
            getOption()
            binding.option.text =
                """ 사이즈: $size $shot $syrup $ice""".trimIndent()
        }

        private fun getOption(){
            size =
                if(drinkItem.size == 0){
                    "Regular"
                } else{
                    "Extra"
                }

            for (i in 0 until drinkItem.option.size){
                when(drinkItem.option[i]){
                    "shot" -> shot = "샷 추가"
                    "ice" -> ice = "얼음 추가"
                    "syrup" -> syrup = "시럽 추가"
                }
            }
        }

    }
}