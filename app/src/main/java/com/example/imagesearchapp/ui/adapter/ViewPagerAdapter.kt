package com.example.imagesearchapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imagesearchapp.ui.fragment.FirstFragment
import com.example.imagesearchapp.ui.fragment.SecondFragment

private const val NUM_TABS = 2
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return FirstFragment()
            1 -> return SecondFragment()
        }
        return SecondFragment()
    }
}