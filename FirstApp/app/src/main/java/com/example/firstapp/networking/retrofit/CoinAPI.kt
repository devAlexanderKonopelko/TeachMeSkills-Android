package com.example.firstapp.networking.retrofit

import com.example.firstapp.networking.entity.Coins
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinAPI {
    @GET("cryptocurrency/listings/latest")
    fun getTopCoins(
        @Query("limit")
        limit: Int,
        @Query("convert")
        currencyCode: String) :Deferred<Response<Coins>>
}