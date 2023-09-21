package com.example.imagesearchapp.ui.model

import com.google.gson.annotations.SerializedName

// 카카오 이미지 검색 API의 응답에서
// METADATA 와 이미지정보목록(document)를 나타 냄

// 결과는 이 클래스로 받아 옴

data class ImageSearchResponse(
    @SerializedName("meta")
    val metaData: MetaData?,

    @SerializedName("documents")
    val documents : MutableList<KakaoImage>?
)





//@SerializedName은 JSON 데이터의 필드 이름과 Kotlin 클래스의 속성 이름을 매핑하기 위해 사용
// JSON 데이터와 Kotlin 클래스 간에 이름이 다른 경우에 사용