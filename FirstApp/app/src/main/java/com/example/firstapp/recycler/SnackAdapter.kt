package com.example.firstapp.recycler

import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_item.view.*


class SnackAdapter(val list: ArrayList<Snack>, val supportFragmentManager: FragmentManager,val fragmentView: FrameLayout) :
    RecyclerView.Adapter<SnackAdapter.SnackViewHolder>() {

    class SnackViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SnackViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_item, parent, false)
        return SnackViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SnackViewHolder, position: Int) {
        val snackView = holder.itemView

        Picasso.get().load(list.get(position).imageUrl).into(snackView.snackImage)
        snackView.snackName.text =list.get(position).name
        snackView.snackDescription.text =list.get(position).description
        snackView.snackPrice.text =list.get(position).price.toString()


        val detailsFragment = SnackDetailsFragment(position)

        snackView.setOnClickListener {
            if (snackView.context.resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
                val intent = Intent(snackView.context, SnackDetailsActivity::class.java)
                intent.putExtra("SNACK_IMAGE_URL", list.get(position).imageUrl)
                intent.putExtra("SNACK_NAME", list.get(position).name)
                intent.putExtra("SNACK_DESCRIPTION", list.get(position).description)
                intent.putExtra("SNACK_PRICE", list.get(position).price)

                snackView.context.startActivity(intent)
            }
            else if (snackView.context.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
                supportFragmentManager.beginTransaction().replace(fragmentView.id, detailsFragment).commit()

                println("Clicked")
            }
        }
    }


}