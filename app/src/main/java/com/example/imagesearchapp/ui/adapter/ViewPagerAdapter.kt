package com.example.imagesearchapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.imagesearchapp.ui.fragment.SearchFragment
import com.example.imagesearchapp.ui.fragment.BookMarkFragment

private const val NUM_TABS = 2
class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return NUM_TABS
    }

    override fun createFragment(position: Int): Fragment {
        when (position) {
            0 -> return SearchFragment()
            1 -> return BookMarkFragment()
        }
        return BookMarkFragment()
    }
}

//어떤 Tab을 눌렀을 때, 어떤 Fragment가 생성되어야 하는지 구체적인 내용 구현