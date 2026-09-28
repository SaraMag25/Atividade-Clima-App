package com.example.atividade_clima_app.model

import retrofit2.http.GET

interface PostApiService {
    // o posts se refere ao caminho da url da API
    //https://jsonplaceholder.typicode.com/posts
    @GET("posts")
    suspend fun getPosts(): List<Post>
}