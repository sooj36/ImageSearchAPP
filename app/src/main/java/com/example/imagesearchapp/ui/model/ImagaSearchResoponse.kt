package com.example.imagesearchapp.ui.model

import com.google.gson.annotations.SerializedName

data class ImagaSearchResoponse(
    @SerializedName("meta")
    val metaData: MetaData?,

    @SerializedName("documents")
    val documents : MutableList<KakaoImage>?
)

// KakaoImage, MetaData 를 사용
// 결과는 이 클래스로 받아 옴