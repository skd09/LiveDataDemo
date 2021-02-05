package com.sharvari.livedatademo

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TextViewModel : ViewModel(){

    val mutableText  = MutableLiveData<String>()
    val text : LiveData<String> get() = mutableText

    fun updatedText(text : String){
        mutableText.value = text
    }

}