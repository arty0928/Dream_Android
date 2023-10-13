package com.example.hyoja.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import android.util.Log

class SetMenuMyAdapter(

    fragmentActivity: FragmentActivity,
    private val fragments: List<Fragment>) :
    FragmentStateAdapter(fragmentActivity) {


    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}