package com.example.atividade_clima_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.net.URL

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    TelaSara(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun TelaSara(modifier: Modifier = Modifier) {
    var temperatura by remember { mutableStateOf("Buscando...") }
    var vento by remember { mutableStateOf("") }
    var erro by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        try {
            val resposta = withContext(Dispatchers.IO) {
                URL("https://api.open-meteo.com/v1/forecast?latitude=-3.7172&longitude=-38.5431&current_weather=true").readText()
            }
            val json = JSONObject(resposta).getJSONObject("current_weather")
            temperatura = "${json.getDouble("temperature")} °C"
            vento = "${json.getDouble("windspeed")} km/h"
        } catch (e: Exception) {
            erro = true
        }
    }

    Column(modifier = modifier.padding(24.dp)) {
        Text("Consumo de API da Sara - Tempo", style = MaterialTheme.typography.titleLarge)
        Spacer(modifier = Modifier.height(16.dp))

        if (erro) {
            Text("Falha ao conectar com a API", color = MaterialTheme.colorScheme.error)
        } else {
            Card(modifier = Modifier.fillMaxWidth()) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("Local: Fortaleza, CE")
                    Text("Temperatura Atual: $temperatura")
                    if (vento.isNotEmpty()) {
                        Text("Velocidade do Vento: $vento")
                    }
                }
            }
        }
    }
}