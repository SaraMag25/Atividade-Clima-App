package com.example.atividade_clima_app.API

import com.example.atividade_clima_app.model.PostApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val URL = "https://jsonplaceholder.typicode.com/"

    private val retrofit = Retrofit
        .Builder()
        .baseUrl(URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api: PostApiService = retrofit.create(PostApiService::class.java)
}