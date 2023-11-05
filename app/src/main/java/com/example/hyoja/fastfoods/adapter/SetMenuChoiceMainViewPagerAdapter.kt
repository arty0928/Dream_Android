package com.example.hyoja.fastfoods.adapter

import FoodListMenuTwoFragment
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hyoja.Fragments.ChoiceSetMenuDialogFragment
import com.example.hyoja.Fragments.FoodListMenuOneFrament
import com.example.hyoja.Fragments.lunch

class SetMenuChoiceMainViewPagerAdapter(fragmentActivity: ChoiceSetMenuDialogFragment): FragmentStateAdapter(fragmentActivity) {

    // 1. ViewPager2에 연결할 Fragment 들을 생성
    private val fragmentList = listOf<Fragment>(
//        FoodListMenuOneFrament(),FoodListMenuTwoFragment()
        lunch(), lunch()
    )


    // 2. ViesPager2에서 노출시킬 Fragment 의 갯수 설정
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    // 3. ViewPager2의 각 페이지에서 노출할 Fragment 설정
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }
}