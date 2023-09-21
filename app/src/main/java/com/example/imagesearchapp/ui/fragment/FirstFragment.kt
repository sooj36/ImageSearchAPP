package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.databinding.FragmentFirstBinding
import com.example.imagesearchapp.ui.adapter.FirstAdapter
import com.example.imagesearchapp.ui.repository.Repository
import com.example.imagesearchapp.ui.viewModel.MainViewModel
import com.example.imagesearchapp.ui.viewModel.MainViewModelFactory


class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    private lateinit var adapter : FirstAdapter

    // Main.kt 의 viewmodel 사용
    private lateinit var viewModel: MainViewModel
    // 데이터를 가지고 있음

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        val factory = MainViewModelFactory(Repository())
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("sooj", "onViewCreated()")

        adapter = FirstAdapter()

        //버튼 찾아 변수 할당
        binding.searchBtn.setOnClickListener {
            val query = binding.searchBar.text.toString()
            viewModel.searchImage(query)
            Log.d("sooj", "click")
        }

        binding.recyclerview1.layoutManager = GridLayoutManager(view.context, 2)
        Log.d("sooj", "layoutmanager")


        // floatingBtn 클릭시 최상단으로
        binding.btnToTop.setOnClickListener {
            binding.recyclerview1.layoutManager = GridLayoutManager(context, 2)
            binding.recyclerview1.smoothScrollToPosition(0)
            Log.d("sooj", "click to top")
        }
        viewModel.searchResult.observe(viewLifecycleOwner) { images ->
            adapter.list.clear()
            images ?: return@observe
            adapter.list.addAll(images)
            adapter.notifyDataSetChanged()
            Log.d("sooj", "observe")
        }

        binding.recyclerview1.adapter = adapter
        Log.d("sooj", "recyclerview에ㅓ 어댑터 연결")
    }

}


