package com.example.imagesearchapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.example.imagesearchapp.BuildConfig
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.ActivityMainBinding
import com.example.imagesearchapp.ui.adapter.ViewPagerAdapter
import com.example.imagesearchapp.ui.repository.Repository
import com.example.imagesearchapp.ui.viewModel.SearchViewModel
import com.example.imagesearchapp.ui.viewModel.SearchViewModelFactory

// TabLayout , ViewPager2 연동

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    val repository = Repository()
    val viewModelFactory = SearchViewModelFactory(repository)

    // by lazy == 변수 지연 초기화
    // viewmodelprovider == 클래스 생성자를 호출하여 뷰모델 생성
    // .get(SearchViewModel::class.java) == 서치뷰모델 클래스의 인스턴스를 생성+반환

    val viewModel by lazy {
        ViewModelProvider(
            this,
            viewModelFactory
        ).get(SearchViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initViewPager()
        initNavigation()


        BuildConfig.API_KEY

    }

    private fun initViewPager() {
        val viewPager = binding.viewPager
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        //page에 adapter 연결
        viewPager.adapter = viewPagerAdapter

        //ViewPager 로 슬라이드 시, BottomNavigation 도 페이지 활성화
        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.bottomNavigation.menu.getItem(position).isChecked = true
            }
        })

    }

    // 앱의 네비게이션 로직을 초기화하고 항목을 클릭했을 때, 해당 프래그먼트로 이동 (initNavigation)
    //BottomNavigation의 선택된 메뉴의 리스너를 설정 (OnNavigationItemSelected)(권장)
    private fun initNavigation() {

        binding.bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) { ////////////////////////////////////////////////////////////클릭된 아이템의 식별자 나타냄
                R.id.search -> {
                    binding.viewPager.currentItem = 0
                    true
                }

                R.id.storage -> {
                    binding.viewPager.currentItem = 1
                    true
                }

                else -> false
            }
        }
    }
}