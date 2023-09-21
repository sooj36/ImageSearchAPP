package com.example.imagesearchapp.ui.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.ui.model.ImageSearchResponse
import com.example.imagesearchapp.ui.model.KakaoImage
import com.example.imagesearchapp.ui.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    // LiveData == 데이터 변경 관찰 UI에 바인딩
    private val _searchResult : MutableLiveData<List<KakaoImage>?> = MutableLiveData()
    val searchResult : LiveData<List<KakaoImage>?> get() = _searchResult



    // 검색어를 매개변수로 받도록
    fun searchImage(query: String){
        viewModelScope.launch {
            val response = repository.searchImage(query,"relevance")
            val result = response.body()?.documents
            Log.d("sooj", "searchImage ${result}")
            _searchResult.value = result

        }
    }
}