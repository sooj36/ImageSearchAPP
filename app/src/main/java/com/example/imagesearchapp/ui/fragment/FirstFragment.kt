package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.GridLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentFirstBinding
import com.example.imagesearchapp.ui.viewModel.MainViewModel


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

    // Main.kt 의 viewmodel 사용
    private val viewModel: MainViewModel by activityViewModels()
    // 데이터를 가지고 있음

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("sooj", "onViewCreated()")

        //버튼 찾아 변수 할당
        binding.searchBtn.setOnClickListener {
            val query = binding.searchBar.text.toString()
            viewModel.searchImage(query)
            Log.d("sooj", "click")
        }

        // floatingBtn 클릭시 최상단으로
        binding.btnToTop.setOnClickListener {
            binding.recyclerview.layoutManager = GridLayoutManager(context, 2)
            binding.recyclerview.smoothScrollToPosition(0)
        }
    }
}


