package com.example.simpleapicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Retrofitobject {
    private val retrofit by lazy {
    Retrofit.Builder().baseUrl(" https://meme-api.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }
    val apiservice by lazy {
        retrofit.create(ApiInterface::class.java)

    }
}
















