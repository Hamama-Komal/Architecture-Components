package com.example.architecturecomponents.classes

import androidx.lifecycle.ViewModel

class MainViewModel(startingValue: Int) : ViewModel() {

    var count = startingValue

    fun increment(){
        count++
    }
}