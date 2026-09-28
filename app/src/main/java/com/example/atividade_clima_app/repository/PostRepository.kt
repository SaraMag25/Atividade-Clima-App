package com.example.atividade_clima_app.repository

import com.example.atividade_clima_app.model.Post
import com.example.atividade_clima_app.model.PostApiService

class PostRepository (private val api: PostApiService) {
    suspend fun getPosts(): List<Post>{
        return api.getPosts()
    }
}