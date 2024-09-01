package com.example.imagesearchapp.ui.api

import com.example.imagesearchapp.ui.config.Constants.Companion.AUTH_HEADER
import com.example.imagesearchapp.ui.model.ImageSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface KakaoSearchApi {
    @GET("v2/search/image")
    suspend fun searchImage(
        @Header("Authorization") apiKey : String = AUTH_HEADER,
        @Query("query") query: String,
        @Query("sort") sort : String,
        @Query("page") page : Int,
        @Query("size") size : Int
    ) : Response<ImageSearchResponse>
}

// retrofit을 사용하여 웹api 와 통신하기 위한 http 요청 메서드를 정의하는데 사용
// retrofit은 이 인터페이스를 구현하고, 이 메서드를 호출하여 웹 서버에 http 요청 보내고, 서버에서 반환된 응답 처리