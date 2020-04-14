package com.example.firstapp.networking.entity

data class Data(
    val id: Int,
    val name: String,
    val quote: Quote,
    var color: Int = 0
)