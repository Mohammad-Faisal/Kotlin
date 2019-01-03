package com.example.faisal.diceroller.recycler

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.faisal.diceroller.R
import kotlinx.android.synthetic.main.item_list.view.*


class Adapter(val items : ArrayList<String>, val context: Context ,val activity : Activity) : RecyclerView.Adapter<ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.type?.text = items.get(position)
    }

    // Gets the number of animals in the list
    override fun getItemCount(): Int =items.size
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val type = view.tv_animal_type
}