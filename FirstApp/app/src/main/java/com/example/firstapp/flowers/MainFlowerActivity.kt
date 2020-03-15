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

    override fun onStart() {
        super.onStart()
        Log.e("START", "OnStart");
        val model = ViewModelProvider(this).get(MyViewModel::class.java)

        when (FlowersList.flowers.flowersList.size) {
            1 -> {
                model.setFlowerTopFragment(fragmentTop)
            }
            2 -> {
                model.setFlowerTopFragment(fragmentTop)
                model.setFlowerBottomFragment(fragmentBottom)
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            addFlower.id -> {
                val newIntent = Intent(this, AddFlowerActivity::class.java)
                startActivityForResult(newIntent, ADD_FLOWER)
            }
            addTopFragment.id -> {
                if (fragmentTop.getFlower() != null) {
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
                if (fragmentBottom.getFlower() != null) {
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
                if (fragmentTop.getFlower() != null) {
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
                if (fragmentBottom.getFlower() != null) {
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
                newIntent.putExtra("URL", fragmentTop.getFlower()?.url)
                newIntent.putExtra("NAME", fragmentTop.getFlower()?.name)
                newIntent.putExtra("PRICE", fragmentTop.getFlower()?.price)
                startActivity(newIntent)
            }
            bottomFragment.id -> {
                val newIntent = Intent(this, DetailsActivity::class.java)
                newIntent.putExtra("URL", fragmentBottom.getFlower()?.url)
                newIntent.putExtra("NAME", fragmentBottom.getFlower()?.name)
                newIntent.putExtra("PRICE", fragmentBottom.getFlower()?.price)
                startActivity(newIntent)
            }
        }
    }
}
