package com.example.imagesearchapp.ui.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.imagesearchapp.ui.model.KakaoImage



class BookMarkViewModel() : ViewModel() {

    // LiveData == 데이터 변경 관찰 UI에 바인딩
    // bookmark viewmodel

    private val _bookMark : MutableLiveData<List<KakaoImage>?> = MutableLiveData()
    val bookMark : LiveData<List<KakaoImage>?> get() = _bookMark


    fun addBookMark(item: KakaoImage) {
        val currentList = _bookMark.value?.toMutableList() ?: mutableListOf()
        currentList.add(item)
        _bookMark.value = currentList
    }

    fun removeBookMark(item: KakaoImage) {
        val removeList = _bookMark.value?.toMutableList() ?: mutableListOf()
        removeList.remove(item)
        _bookMark.value = removeList
    }
}