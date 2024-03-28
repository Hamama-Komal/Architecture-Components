package com.example.architecturecomponents.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LiveDataViewModel : ViewModel() {

    private val quoteMutableLiveData = MutableLiveData("You can observe a lot just by watching.")

    // To convert MutableLiveData into LiveData
    val quoteLiveData : LiveData<String> = quoteMutableLiveData

    fun updateLiveData(){

       quoteMutableLiveData.value = "Difficulties increase the nearer we get to the goal."
        // Live data cannot be update
       // quoteLiveData = "Difficulties increase the nearer we get to the goal."       // throw error
    }
}