package com.example.retrofitwithimage

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithimage.model.Data
import com.squareup.picasso.Picasso


class MyAdapter(private val dataList:MutableList<Data>):RecyclerView.Adapter<MyHolder>() {
    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view,
                parent, false))

    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val data=dataList[position]
        val fullname=holder.fullname
      val  userAvatarImgView=holder.image
        fullname.text= fullname.toString()
        Picasso.get()
            .load(data.avatar)
            .into(userAvatarImgView)


    }

    override fun getItemCount(): Int=dataList.size

}