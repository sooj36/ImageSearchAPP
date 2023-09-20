package com.example.imagesearchapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.ui.model.ImageSearchResponse
import com.example.imagesearchapp.ui.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myCustomPosts : MutableLiveData<Response<ImageSearchResponse>> = MutableLiveData()


    // 검색어를 매개변수로 받도록
    fun searchImage(query: String){
        viewModelScope.launch {
            val response = repository.searchImage(query,"relevance")
            myCustomPosts.value = response
            Log.d("sooj", "searchImage")
        }
    }
}