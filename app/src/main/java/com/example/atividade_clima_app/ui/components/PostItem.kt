package com.example.atividade_clima_app.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.atividade_clima_app.model.Post

@Composable
fun PostItem(post: Post) {

    Card(
        modifier = Modifier
            .padding(bottom = 12.dp)
    ) {

        Column(
            modifier = Modifier.padding(16.dp)
        ) {

            Text(
                text = post.title,
                style = MaterialTheme.typography.titleMedium
            )

            Text(
                text = post.body,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}