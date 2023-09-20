package com.example.imagesearchapp.ui.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imagesearchapp.ui.model.ImageSearchResponse
import com.example.imagesearchapp.ui.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository) : ViewModel() {

    val myCustomPosts : MutableLiveData<Response<ImageSearchResponse>> = MutableLiveData()

    fun searchImage(){
        viewModelScope.launch {
            val response = repository.searchImage("페이커","accuracy")
            myCustomPosts.value = response
        }
    }


}