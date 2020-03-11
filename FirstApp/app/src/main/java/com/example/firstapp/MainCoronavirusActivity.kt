package com.example.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.lifecycle.viewModelScope
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_main_coronavirus.*
import kotlinx.coroutines.launch

class MainCoronavirusActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coronavirus)
        val model = ViewModelProvider(this).get(MyViewModel::class.java)
        lifecycle.addObserver(MyLifeObserver())


        plusConfBtn.setOnClickListener(this)
        plusDeadBtn.setOnClickListener(this)
        plusRecBtn.setOnClickListener(this)

        showStats()

        model.currentStats.observe(this, Observer {
            confirmedCount.text = it.get(0).toString()
            deadCount.text = it.get(2).toString()
            recoveredCount.text = it.get(1).toString()
        })

        refreshData.setOnClickListener {
            model.viewModelScope.launch {
                model.getDataFromInternet()
            }
        }
    }

    private fun showStats() {
        val model = ViewModelProvider(this).get(MyViewModel::class.java)
        confirmedCount.text = model.confirmed.toString()
        deadCount.text = model.dead.toString()
        recoveredCount.text = model.recovered.toString()
    }

    override fun onClick(v: View?) {
        val model = ViewModelProvider(this).get(MyViewModel::class.java)
        when (v?.id) {
            R.id.plusConfBtn -> {
                model.confirmed++
                confirmedCount.text = model.confirmed.toString()
            }
            R.id.plusDeadBtn -> {
                model.dead++
                deadCount.text = model.dead.toString()
            }
            R.id.plusRecBtn -> {
                model.recovered++
                recoveredCount.text = model.recovered.toString()
            }
        }

    }
}
