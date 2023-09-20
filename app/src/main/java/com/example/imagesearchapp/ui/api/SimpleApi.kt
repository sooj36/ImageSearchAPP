package com.example.imagesearchapp.ui.api

import com.example.imagesearchapp.ui.config.Constants.Companion.AUTH_HEADER
import com.example.imagesearchapp.ui.model.ImageSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SimpleApi {
    @GET("v2/search/image")
    suspend fun searchImage(
        @Header("Authorization") apiKey : String = AUTH_HEADER,
        @Query("query") query: String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : Response<ImageSearchResponse>
}