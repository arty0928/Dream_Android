package com.example.hyoja.Adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hyoja.Fragments.FoodListMenuOneFrament

class SetMenuMyAdapter(

    fragmentActivity: FoodListMenuOneFrament,
    private val fragments: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}