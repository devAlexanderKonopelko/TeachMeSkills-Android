package com.example.firstapp

import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent

class MyLifeObserver : LifecycleObserver {

    val TAG = "MyLifeObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun execute(owner: LifecycleOwner, event: Lifecycle.Event) {

        when (event) {
            Lifecycle.Event.ON_CREATE -> Log.e(TAG, "create")
            Lifecycle.Event.ON_START -> Log.e(TAG, "start")
            Lifecycle.Event.ON_RESUME -> Log.e(TAG, "resume")
            Lifecycle.Event.ON_PAUSE -> Log.e(TAG, "pause")
            Lifecycle.Event.ON_STOP -> Log.e(TAG, "stop")
            Lifecycle.Event.ON_DESTROY -> Log.e(TAG, "destroy")
            else -> Log.e(TAG, "else")
        }
    }
}