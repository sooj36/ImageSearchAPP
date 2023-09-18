package com.example.imagesearchapp.ui.model

import com.google.gson.annotations.SerializedName

data class KakaoImage(
    @SerializedName("display_sitename")
    val sitename : String,
    val collection: String,
    val image_url : String
)

//화면에 띄울 것 / sitename, 날짜,시간/


