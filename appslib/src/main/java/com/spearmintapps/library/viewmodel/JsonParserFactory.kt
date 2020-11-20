package com.spearmintapps.library.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class JsonParserFactory(val context: Context) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(JsonParser::class.java)) return JsonParser(context) as T
        throw IllegalArgumentException("Unknown class name")
    }
}