package com.example.firstapp.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import kotlinx.android.synthetic.main.activity_main_recycler.*

class MainRecyclerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_recycler)

        SnackCollection.instance.removeAllSnacks()
        SnackCollection.instance.addSomeSnacks()

        recyclerView.adapter = SnackAdapter(
            SnackCollection.instance.snackCollection,
            supportFragmentManager,
            snackDetailsFragment
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

    }


}
