package com.pmdm.example.botones

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UI(viewModel: ViewModel = ViewModel()) {
    val lightGreen = Color(0xFFCCFFCC)
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(lightGreen)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Simon dice",
                    style = MaterialTheme.typography.headlineMedium,
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Ronda: ${viewModel.datos.value.rondaActual}",
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = "Combinación a pulsar: ${viewModel.datos.value.secuenciaBotones.joinToString()}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Boton.entries.toTypedArray().take(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { viewModel.onButtonClicked(boton.numero) })
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Boton.entries.drop(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { viewModel.onButtonClicked(boton.numero) })
                }
            }
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(25.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Boton_Start(onClick = { viewModel.generateSequence() })
                }
                Text(
                    text = viewModel.datos.value.mensaje,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

@Composable
fun Boton_Start(onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp)
    ) {
        Text(text = "Start", color = Color.White)
    }
}

@Composable
fun CustomButton(boton: Boton, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = boton.color),
        modifier = Modifier
            .padding(bottom = 16.dp),
    ) {
        Text(text = "${boton.numero}", color = boton.textColor)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
    UI()
}

