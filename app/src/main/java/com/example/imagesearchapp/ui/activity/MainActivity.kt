package com.example.imagesearchapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.imagesearchapp.databinding.ActivityMainBinding
import com.example.imagesearchapp.ui.adapter.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

// TabLayout , ViewPager2 연동

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private val tabTitleArray:Array<String> = arrayOf(
        "검색 결과",
        "내 보관함"
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewpager
        val tabLayout = binding.tablayout

        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}