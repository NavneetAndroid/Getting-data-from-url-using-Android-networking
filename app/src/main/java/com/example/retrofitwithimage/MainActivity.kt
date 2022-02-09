package com.example.retrofitwithimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.OrientationHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithimage.model.Data
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.example.retrofitwithimage.model.Reqres
import com.androidnetworking.interfaces.ParsedRequestListener



class MainActivity : AppCompatActivity() {
    val my_recycler_view= findViewById<RecyclerView>(R.id.recycler)
    private  val  datlist:MutableList<Data> = mutableListOf()
    private lateinit var myAdapter: MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myAdapter= MyAdapter(datlist)


        my_recycler_view.layoutManager=LinearLayoutManager(this)
        my_recycler_view.addItemDecoration(DividerItemDecoration(this,OrientationHelper.VERTICAL))
        my_recycler_view.adapter=myAdapter



        AndroidNetworking.initialize(this)
        AndroidNetworking.get("https://reqres.in/api/users?page=1")
            .build()
            .getAsObject(Reqres::class.java, object : ParsedRequestListener<Reqres> {
                override fun onResponse(response: Reqres?) {
                    if (response != null) {
                        datlist.addAll(response.data)
                    }
                    myAdapter.notifyDataSetChanged()

                }

                override fun onError(anError: ANError?) {

                }

            })






    }
}