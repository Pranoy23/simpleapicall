package com.example.simpleapicall

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("gimme")
    fun  getdata():Call<responseDataclass>


}