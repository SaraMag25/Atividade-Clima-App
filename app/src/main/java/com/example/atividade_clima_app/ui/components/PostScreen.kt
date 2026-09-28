package com.example.atividade_clima_app.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.atividade_clima_app.viewModel.PostViewModel

@Composable
fun PostScreen(
    viewModel: PostViewModel = viewModel()
) {

    val posts by viewModel.posts.collectAsState()

    Spacer(Modifier.height(20.dp))
    Text("API do Raí - Dados Fictícios", style = MaterialTheme.typography.titleLarge)
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        items(posts.take(5)) { post ->
            PostItem(post)
        }
    }
}