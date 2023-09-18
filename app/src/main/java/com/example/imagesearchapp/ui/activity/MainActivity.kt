package com.example.imagesearchapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
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

        // viewpager,tablayout 참조
        val viewPager = binding.viewpager
        val tabLayout = binding.tablayout

        // viewpager의 adapter 설정
        viewPager.adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        // tablayout - viewpager 연결 , tabitem 메뉴명 설정
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabTitleArray[position]
        }.attach()
    }
}