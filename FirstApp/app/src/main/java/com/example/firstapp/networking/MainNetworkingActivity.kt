package com.example.firstapp.networking

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.networking.entity.Coins
import com.example.firstapp.networking.recycler.CoinAdapter
import com.example.firstapp.networking.retrofit.CoinApiFactory
import kotlinx.android.synthetic.main.activity_main_networking.*
import kotlinx.android.synthetic.main.activity_main_recycler.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainNetworkingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_networking)

        floatingButton.setColorFilter(Color.argb(255, 255, 255, 255))
        CoroutineScope(Dispatchers.IO).launch {
            val response =CoinApiFactory.getRetrofit().getTopCoins(10, "BYN").await()

            if (response.isSuccessful) {
                val coins = response.body()

                if (coins != null) {

                    withContext(Dispatchers.Main) {
                        recyclerViewCrypto.adapter = CoinAdapter(coins.data, this@MainNetworkingActivity)
                        recyclerViewCrypto.layoutManager = LinearLayoutManager(this@MainNetworkingActivity)
                        recyclerViewCrypto.setHasFixedSize(true)
                    }
                }

            }
        }
    }
}
