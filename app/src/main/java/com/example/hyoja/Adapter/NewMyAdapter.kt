package com.example.hyoja.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class NewMyAdapter(
    val fragmentList: ArrayList<Fragment>,
    fm: FragmentManager,
    lifecycle: Lifecycle
): FragmentStateAdapter(fm,lifecycle){

    override fun getItemCount(): Int {
        return fragmentList.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}