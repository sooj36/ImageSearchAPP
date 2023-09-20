package com.example.imagesearchapp.ui.repository

import com.example.imagesearchapp.ui.api.RetrofitInstance
import com.example.imagesearchapp.ui.model.ImageSearchResponse
import retrofit2.Response

class Repository {

    suspend fun searchImage (query: String, sort : String) : Response<ImageSearchResponse> {
        return RetrofitInstance.api.searchImage(query = query, sort = sort, page  = 1, size = 80)
    }
}