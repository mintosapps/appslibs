package com.spearmintapps.library.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.spearmintapps.library.model.ComponentContent
import com.spearmintapps.library.model.FileUrlPair
import com.spearmintapps.library.model.SayPair

class JsonParser(val context: Context) : ViewModel() {
    fun loadPdfs(fileName: String): LiveData<List<FileUrlPair>> {
        //Read the PostJSON.json file
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        //Convert the Json File to Gson Object
        val listOfFiles: List<FileUrlPair> =
            Gson().fromJson(jsonString, Array<FileUrlPair>::class.java).toList()
        return MutableLiveData(listOfFiles)
    }

    fun loadLibs(): MutableLiveData<List<ComponentContent>> {
        //Read the PostJSON.json file
        val jsonString = context.assets.open("libs.json").bufferedReader().use {
            it.readText()
        }
        //Convert the Json File to Gson Object
        val listOfContents = Gson().fromJson(jsonString, Array<ComponentContent>::class.java).toList()
        return MutableLiveData(listOfContents)
    }


    fun loadTheSayersAndSays(): MutableLiveData<List<SayPair>> {
        //Read the PostJSON.json file
        val jsonString = context.assets.open("sayings.json").bufferedReader().use {
            it.readText()
        }
        //Convert the Json File to Gson Object
        return MutableLiveData(Gson().fromJson(jsonString, Array<SayPair>::class.java).toList())
    }
}