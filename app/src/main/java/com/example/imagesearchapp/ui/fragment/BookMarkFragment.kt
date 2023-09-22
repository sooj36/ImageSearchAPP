package com.example.imagesearchapp.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.imagesearchapp.databinding.FragmentBookmarkBinding
import com.example.imagesearchapp.ui.adapter.BookMarkAdapter
import com.example.imagesearchapp.ui.model.KakaoImage
import com.example.imagesearchapp.ui.viewModel.BookMarkViewModel


class BookMarkFragment : Fragment(),BookMarkAdapter.OnBookmarkClickListener {

    // 바인딩 객체를 null 허용으로
//    private lateinit var binding: FragmentSecondBinding? = null
    private lateinit var adapter: BookMarkAdapter
    private lateinit var binding: FragmentBookmarkBinding
    private val viewModel by activityViewModels<BookMarkViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBookmarkBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = BookMarkAdapter()
        adapter.listener = this

        binding.recyclerview2.adapter = adapter

        binding.recyclerview2.layoutManager = GridLayoutManager(view.context, 2)
        Log.d("sooj", "recyclerview 2")

        // livedata 이용해 viewmodel에서 제공하는 데이터를 관찰, 데이터가 변경될때마다 recyclerview에 새 데이터를 표시
        viewModel.bookMark.observe(viewLifecycleOwner) { images ->
            adapter.bookmark.clear()
            images ?: return@observe
            adapter.bookmark.addAll(images)
            adapter.notifyDataSetChanged()
            Log.d("sooj", "observe $images")
        }
    }


    override fun onBookmarkClicked(kakaoImage: KakaoImage) {
        //북마크 클릭시
        viewModel.removeBookMark(kakaoImage)
        Toast.makeText(context , "북마크가 제거되었습니다", Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}








