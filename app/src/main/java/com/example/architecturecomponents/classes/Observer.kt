package com.example.architecturecomponents.classes

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class Observer : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun observerOnCreate() {
        Log.d("MAIN", "Observer - OnCreate")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun observerOnStart() {
        Log.d("MAIN", "Observer - OnStart")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun observerOnPause() {
        Log.d("MAIN", "Observer - OnPause")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun observerOnResume() {
        Log.d("MAIN", "Observer - OnResume")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun observerOnDestroy() {
        Log.d("MAIN", "Observer - OnDestroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun observerOnStop() {
        Log.d("MAIN", "Observer - OnStop")
    }


}