package com.example.hyoja.cafe.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hyoja.cafe.model.CafeModel
import com.example.hyoja.databinding.FragmentPayBinding
import com.example.hyoja.databinding.OrderedListItemBinding
import com.example.hyoja.databinding.PayOrderedDrinksBinding

class PayRecyclerViewAdapter: RecyclerView.Adapter<PayRecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(PayOrderedDrinksBinding.inflate(LayoutInflater.from(parent.context),parent,false))

    override fun getItemCount(): Int = CafeModel.drinkSelectedList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView
    }
    class ViewHolder(itemView: PayOrderedDrinksBinding): RecyclerView.ViewHolder(itemView.root){

    }
}