package com.dream.hyoja.cafe.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.dream.hyoja.cafe.fragment.PayFragment
import com.dream.hyoja.cafe.fragment.SavingPointFragment

class PayViewPagerAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    private val payFragment = PayFragment()
    private val savingPointFragment = SavingPointFragment()
    // 1. ViewPager2에 연결할 Fragment 들을 생성
    private val fragmentList = listOf<Fragment>(
        payFragment, savingPointFragment
    )

    // 2. ViesPager2에서 노출시킬 Fragment 의 갯수 설정
    override fun getItemCount(): Int {
        return fragmentList.size
    }

    // 3. ViewPager2의 각 페이지에서 노출할 Fragment 설정
    override fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

    fun setNextListener(nextListener: PayFragment.NextListener){

    }

}
