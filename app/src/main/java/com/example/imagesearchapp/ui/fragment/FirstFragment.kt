package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.activityViewModels
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentFirstBinding
import com.example.imagesearchapp.ui.viewModel.MainViewModel


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    // Main.kt 의 viewmodel 사용
    private val viewModel : MainViewModel by activityViewModels()
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

        //버튼 찾아 변수 할당
        binding.searchBtn.setOnClickListener{
            ///api 연결//
        }



        }
    }


