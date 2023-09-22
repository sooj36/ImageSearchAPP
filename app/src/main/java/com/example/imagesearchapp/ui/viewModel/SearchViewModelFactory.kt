package com.example.imagesearchapp.ui.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.imagesearchapp.ui.repository.Repository

//뷰 모델에 인자를 넘겨주기 위한 팩토리 메서드
class SearchViewModelFactory (
    private val repository: Repository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SearchViewModel(repository) as T
    }
}