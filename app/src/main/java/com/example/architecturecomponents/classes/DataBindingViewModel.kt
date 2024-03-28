package com.example.architecturecomponents.classes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingViewModel : ViewModel() {

    val quoteDataBinding = MutableLiveData("You can observe a lot just by watching.")
    val authorDataBinding = MutableLiveData("Yogi Berra")

    fun changeQuote(){
        quoteDataBinding.value =  "Difficulties increase the nearer we get to the goal."
        authorDataBinding.value = "Johann Wolfgang von Goethe"
    }

}