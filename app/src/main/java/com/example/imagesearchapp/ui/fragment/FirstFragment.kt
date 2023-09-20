package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.imagesearchapp.R
import com.example.imagesearchapp.databinding.FragmentFirstBinding


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding

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
        val SearchButton = view.findViewById<Button>(R.id.search_btn)

        //버큰 클릭 리스너 설정
        SearchButton.setOnClickListener {
            // 여기에 검색 버튼을 클릭 시, 할 동작 구현
            // ex, api 호출 등 처리

        }
    }


}
