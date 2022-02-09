package com.example.retrofitwithimage

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    val fullname =itemView.findViewById<TextView>(R.id.fullname)
    val image=itemView.findViewById<ImageView>(R.id.image)


}