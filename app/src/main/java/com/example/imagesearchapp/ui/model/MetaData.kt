package com.example.imagesearchapp.ui.model

import com.google.gson.annotations.SerializedName

// JSON 데이터에서 검색 결과의 총 개수, 검색 종료 여부를 나타냄

data class MetaData(
    @SerializedName("total_count")
    val totalCount : Int?,

    @SerializedName("is_end")
    val isEnd : Boolean?
)
