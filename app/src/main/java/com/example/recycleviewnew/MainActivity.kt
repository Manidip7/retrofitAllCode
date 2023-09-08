package com.example.recycleviewnew

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleviewnew.retrofitData.ApiUtill
import com.example.recycleviewnew.retrofitData.MyData
import com.example.recycleviewnew.retrofitData.MyDataItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter: MyAdapter
    var userArrayList : ArrayList<MyDataItem> = ArrayList()
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recView)

            ApiUtill.ApiControlor()?.getData()?.enqueue(object : Callback<MyData?> {
                override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                    var responseBody = response.body()
                    if (responseBody != null) {
                        userArrayList.addAll(responseBody)
                    }
                    myAdapter = MyAdapter(this@MainActivity,userArrayList)
                    recyclerView.adapter = myAdapter
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                }

                override fun onFailure(call: Call<MyData?>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            })

    }
}