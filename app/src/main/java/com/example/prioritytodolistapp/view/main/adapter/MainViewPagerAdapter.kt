package com.example.prioritytodolistapp.view.main.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.prioritytodolistapp.view.home.HomeFragment
import com.example.prioritytodolistapp.view.more.MoreFragment

class MainViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> CalendarFra
            1 -> HomeFragment()
            2 -> MoreFragment()

            else -> HomeFragment()
        }
    }
}