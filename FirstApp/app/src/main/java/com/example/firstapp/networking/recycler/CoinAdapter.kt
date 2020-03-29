package com.example.firstapp.networking.recycler

import android.content.Context
import android.graphics.drawable.GradientDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.networking.entity.Data
import kotlinx.android.synthetic.main.recycler_crypto_item.view.*
import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.random.Random


class CoinAdapter(val list: List<Data>, val context: Context) :
    RecyclerView.Adapter<CoinAdapter.CoinViewHolder>() {
    private var colorslist = ArrayList<Int>()

    class CoinViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.recycler_crypto_item, parent, false)

        return CoinViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        setColors()

        val coinView = holder.itemView
        val price =
            BigDecimal(list[position].quote.BYN.price).setScale(3, RoundingMode.HALF_UP).toString()
//        val change = list[position].quote.BYN.percent_change_1h
        val change = list[position].quote.BYN.percent_change_1h?.let {
            BigDecimal(it).setScale(
                2,
                RoundingMode.HALF_UP
            ).toDouble()
        }


        coinView.cryptoImage.text = list[position].name[0].toString()
        coinView.cryptoName.text = list[position].name
        coinView.cryptoPrice.text = "$$price"

        if (list[position].color == 0) {
            val randomColorPosition = Random.nextInt(colorslist.size)
            list[position].color = randomColorPosition
            val drawableBackground = coinView.cryptoImage.background as GradientDrawable
            drawableBackground.setColor(
                ContextCompat.getColor(
                    context,
                    colorslist[randomColorPosition]
                )
            )
        }


        if (change != null) {
            if (change > 0)  {
                coinView.cryptoChangeValue.text = "1 hour: +$change%"
                coinView.cryptoChangeValue.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.changeGreen
                    )
                )
            }
            else if (change < 0) {
                coinView.cryptoChangeValue.text = "1 hour: -$change%"
                coinView.cryptoChangeValue.setTextColor(
                    ContextCompat.getColor(
                        context,
                        R.color.changeRed
                    )
                )
            }
        } else {
            coinView.cryptoChangeValue.text = "1 hour: 0%"
        }
    }

    private fun setColors() {
        colorslist.add(R.color.changeGreen)
        colorslist.add(R.color.changeRed)
        colorslist.add(R.color.colorBlue)
        colorslist.add(R.color.colorPrimaryDark)
        colorslist.add(R.color.colorYellow)
        colorslist.add(R.color.colorPink)
        colorslist.add(R.color.colorBrown)
    }

}