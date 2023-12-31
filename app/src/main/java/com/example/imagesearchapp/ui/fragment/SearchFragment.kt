package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.databinding.FragmentSearchBinding
import com.example.imagesearchapp.ui.adapter.SearchAdapter
import com.example.imagesearchapp.ui.model.KakaoImage
import com.example.imagesearchapp.ui.repository.Repository
import com.example.imagesearchapp.ui.utils.Utils
import com.example.imagesearchapp.ui.viewModel.BookMarkViewModel
import com.example.imagesearchapp.ui.viewModel.SearchViewModel
import com.example.imagesearchapp.ui.viewModel.SearchViewModelFactory


class SearchFragment : Fragment(), SearchAdapter.OnBookmarkClickListener {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: SearchAdapter

    // Main.kt 의 viewmodel 사용
    private lateinit var viewModel: SearchViewModel
    // 데이터를 가지고 있음

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        val factory = SearchViewModelFactory(Repository())
        viewModel = ViewModelProvider(this, factory).get(SearchViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("sooj", "onViewCreated()")

        //최근 검색어 가져와서 EditText에 설정 !
        val saveSearch = Utils.getSaveSearch(requireContext())
        binding.searchBar.setText(saveSearch)

        adapter = SearchAdapter()
        adapter.listener = this

        //버튼 찾아 변수 할당
        binding.searchBtn.setOnClickListener {
            val query = binding.searchBar.text.toString()
            viewModel.searchImage(query)

            // query 저장
            Utils.setSaveSearch(requireContext(), query)

            //함수구현해서 shared해보기
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
        Log.d("sooj", "recyclerview에 어댑터 연결")
    }

    //Shared 가져오는 방식
    private val bookMarkViewModel by activityViewModels<BookMarkViewModel>()
    override fun onBookmarkClicked(kakaoImage: KakaoImage) {
        //북마크 클릭시
        bookMarkViewModel.addBookMark(kakaoImage)
        Toast.makeText(context, "북마크가 추가되었습니다", Toast.LENGTH_LONG).show()
    }


}


