package com.example.prioritytodolistapp.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.viewpager2.widget.ViewPager2
import com.example.prioritytodolistapp.R
import com.example.prioritytodolistapp.base.BaseActivity
import com.example.prioritytodolistapp.databinding.ActivityMainBinding
import com.example.prioritytodolistapp.view.home.HomeFragment
import com.example.prioritytodolistapp.view.main.adapter.MainViewPagerAdapter
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.activity = this
        binding.viewPagerMain.adapter = MainViewPagerAdapter(this)

        initViewPager()
        initBottomNavigation()
    }

    private fun initViewPager() {
        binding.viewPagerMain.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavigationHomeMain.menu.getItem(position).isChecked = true
            }
        }
        )
    }

    private fun initBottomNavigation() {
        binding.bottomNavigationHomeMain.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.iconBottomNavigationCalendar -> {
                    binding.viewPagerMain.currentItem = 0
                    true
                }
                R.id.iconBottomNavigationHome -> {
                    binding.viewPagerMain.currentItem = 1
                    true
                }
                R.id.iconBottomNavigationMore -> {
                    binding.viewPagerMain.currentItem = 2
                    true
                }
                else -> false
            }
        }
    }


}