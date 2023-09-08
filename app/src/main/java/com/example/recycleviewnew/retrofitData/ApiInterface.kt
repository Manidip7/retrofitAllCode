package com.example.recycleviewnew.retrofitData

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("users")
   fun getData() : Call<MyData>
}