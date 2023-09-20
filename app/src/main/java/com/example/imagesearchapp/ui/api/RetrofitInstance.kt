package com.example.imagesearchapp.ui.api


import com.example.imagesearchapp.ui.config.Constants.Companion.BASE_URL
import retrofit2.Response
import retrofit2.Retrofit.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// 인터페이스를 사용하는 인스턴스.
// Builder는 BASE_URL 와 Converter 를 설정


// object 사용하여 싱글톤 패턴


object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val api : SimpleApi by lazy {
        retrofit.create(SimpleApi::class.java)
    }
}

//object RetrofitInstance {
//    companion object {
//        private const val BASE_URL = "https://dapi.kakao.com/v2/search/image"
//        private var INSTANCE : Retrofit? = null
//
//        fun getInstance() : Retrofit {
//            if (INSTANCE == null) {
//                INSTANCE = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return INSTANCE!!
//        }
//    }
//}