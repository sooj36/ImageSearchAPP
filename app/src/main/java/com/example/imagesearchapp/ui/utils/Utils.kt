package com.example.imagesearchapp.ui.utils

import android.content.Context
import com.example.imagesearchapp.ui.config.Constants.Companion.PREFS_NAME

object Utils {

    // 마지막 검색어 가져옴 (Sharedpreferences)
    fun getSaveSearch(context: Context) : String? {
        val preferences = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        return preferences.getString(PREFS_NAME, null)
    }
}