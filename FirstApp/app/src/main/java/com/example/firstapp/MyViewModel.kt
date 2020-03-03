package com.example.firstapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.delay
import kotlin.random.Random

class MyViewModel : ViewModel() {

    val currentStats = MutableLiveData<ArrayList<Int>>()


    var confirmed = 0
    var recovered = 0
    var dead = 0

     suspend fun getDataFromInternet() {
        delay(2000)
        val list = ArrayList<Int>()
        list.add(Random.nextInt(28000))
        list.add(Random.nextInt(18000))
        list.add(Random.nextInt(50))

        currentStats.postValue(list)
    }


}