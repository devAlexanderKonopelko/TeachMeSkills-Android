package com.example.firstapp.flowers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_main_flowers.*

const val ADD_FLOWER = 0
const val URL = "URL"
const val NAME = "NAME"
const val PRICE = "PRICE"

class MainFlowerActivity : AppCompatActivity(), View.OnClickListener {
    private val fragmentTop = FragmentTop()
    private val fragmentBottom = FragmentBottom()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_flowers)
        Log.e("CREATE", "OnCreate");

        addFlower.setOnClickListener(this)
        addTopFragment.setOnClickListener(this)
        addBottomFragment.setOnClickListener(this)
        removeTopFragment.setOnClickListener(this)
        removeBottomFragment.setOnClickListener(this)
        topFragment.setOnClickListener(this)
        bottomFragment.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            addFlower.id -> {
                val newIntent = Intent(this, AddFlowerActivity::class.java)
                startActivityForResult(newIntent, ADD_FLOWER)
            }
            addTopFragment.id -> {
                if (FlowersList.flowers.flowersList.size > 0) {
                    supportFragmentManager.beginTransaction().replace(topFragment.id, fragmentTop)
                        .commit()
                } else {
                    val newToast = Toast.makeText(
                        this,
                        "Flower not found. Please, add a flower",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            addBottomFragment.id -> {
                if (FlowersList.flowers.flowersList.size > 0) {
                    supportFragmentManager.beginTransaction()
                        .replace(bottomFragment.id, fragmentBottom).commit()
                } else {
                    val newToast = Toast.makeText(
                        this,
                        "Flower not found. Please, add a flower",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            removeTopFragment.id -> {
                if (FlowersList.flowers.flowersList.size > 0) {
                    supportFragmentManager.beginTransaction().remove(fragmentTop).commit()
                } else {
                    val newToast = Toast.makeText(
                        this,
                        "Flower not found. Please, add a flower",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            removeBottomFragment.id -> {
                if (FlowersList.flowers.flowersList.size > 0) {
                    supportFragmentManager.beginTransaction().remove(fragmentBottom).commit()
                } else {
                    val newToast = Toast.makeText(
                        this,
                        "Flower not found. Please, add a flower",
                        Toast.LENGTH_SHORT
                    ).show()
                }

            }

            topFragment.id -> {
                val newIntent = Intent(this, DetailsActivity::class.java)
                newIntent.putExtra("URL", FlowersList.flowers.flowersList[0].url)
                newIntent.putExtra("NAME", FlowersList.flowers.flowersList[0].name)
                newIntent.putExtra("PRICE", FlowersList.flowers.flowersList[0].price)
                startActivity(newIntent)
            }
            bottomFragment.id -> {
                val newIntent = Intent(this, DetailsActivity::class.java)
                newIntent.putExtra("URL", FlowersList.flowers.flowersList[1].url)
                newIntent.putExtra("NAME", FlowersList.flowers.flowersList[1].name)
                newIntent.putExtra("PRICE", FlowersList.flowers.flowersList[1].price)
                startActivity(newIntent)
            }
        }
    }
}
