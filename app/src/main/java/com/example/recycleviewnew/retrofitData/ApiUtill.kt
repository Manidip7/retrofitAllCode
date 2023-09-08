package com.example.recycleviewnew.retrofitData

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiUtill {
    private val BASE_URL = "https://api.github.com/"
    private var retrofit: Retrofit? = null

    fun ApiControlor(): ApiInterface? {
        if (retrofit == null){
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit?.create(ApiInterface::class.java)

    }
}