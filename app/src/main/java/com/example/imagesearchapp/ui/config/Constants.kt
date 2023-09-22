package com.example.imagesearchapp.ui.config

import retrofit2.Retrofit

//상수 저장

class Constants {

    companion object {
        const val BASE_URL ="https://dapi.kakao.com"

        private var INSTANCE: Retrofit? = null

        const val  AUTH_HEADER = "KakaoAK 4fef37c0901dbba01264324ed236e61c"

        const val EMPTY_RESULT = "EMPTY_RESULT"

        const val PREFS_NAME = "sooj"
    }

}