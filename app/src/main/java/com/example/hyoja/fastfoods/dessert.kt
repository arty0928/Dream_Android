package com.example.hyoja.fastfoods

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hyoja.R
class dessert : Fragment() {
    interface MenuUpdateListener {
        fun onMenuItemAdded(menuItem: MenuItem)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_dessert, container, false)

        rootView.findViewById<View>(R.id.dessert1).setOnClickListener {
            val menuItem = MenuItem("포테이토", R.drawable.dessert1, 1800)
            MenuRepository.addMenuItem(menuItem)


        }

        rootView.findViewById<View>(R.id.dessert2).setOnClickListener {
            val menuItem = MenuItem("양념감자", R.drawable.dessert2, 2300)
            MenuRepository.addMenuItem(menuItem)
        }

        rootView.findViewById<View>(R.id.dessert3).setOnClickListener {
            val menuItem = MenuItem("웨지포테이토", R.drawable.dessert3, 2400)
            MenuRepository.addMenuItem(menuItem)
        }

        rootView.findViewById<View>(R.id.dessert4).setOnClickListener {
            val menuItem = MenuItem("치즈스틱", R.drawable.dessert5, 2400)
            MenuRepository.addMenuItem(menuItem)
        }

        rootView.findViewById<View>(R.id.dessert5).setOnClickListener {
            val menuItem = MenuItem("통오징어링", R.drawable.dessert5, 2600)
            MenuRepository.addMenuItem(menuItem)
        }

        rootView.findViewById<View>(R.id.dessert6).setOnClickListener {
            val menuItem = MenuItem("모짜크림치즈볼", R.drawable.dessert6, 2300)
            MenuRepository.addMenuItem(menuItem)
        }

        return rootView
    }

}
