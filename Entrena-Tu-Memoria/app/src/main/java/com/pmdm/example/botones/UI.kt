package com.pmdm.example.botones

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

    // Composable principal de la aplicación. Representa la interfaz de usuario del juego "Simon Dice".
@Composable
fun UI(viewModel: ViewModel = ViewModel()) {
        val lightGreen = Color(0xFFCCFFCC)
    // Box se utiliza para superponer elementos. En este caso, se usa para colocar la imagen de fondo (si la hubiera).
    Box(
        modifier = Modifier
            .fillMaxSize() // El modificador fillMaxSize() hace que el Box ocupe el espacio disponible en la pantalla.
            .background(lightGreen)
    ) {
   // Column se utiliza para organizar elementos verticalmente.
        Column(
            modifier = Modifier
    // Ocupa el tamaño de la pantalla.
                .fillMaxSize()
    // Agrega un padding de 16 dp alrededor de la columna.
                .padding(16.dp),
            verticalArrangement = Arrangement.Center, // Centra verticalmente los elementos dentro de la columna.
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente los elementos dentro de la columna.
        ) {
    // Box para contener el título del juego.
    // fillMaxWidth() hace que el Box ocupe el ancho disponible.
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
    // Texto del título.
                    text = "Simon dice",
    // Estilo del texto del título.
                    style = MaterialTheme.typography.headlineMedium,
    // Alinea el texto en el centro superior del Box.
                    modifier = Modifier.align(Alignment.TopCenter)
                )
            }
    // Agrega un espacio vertical de 16 dp.
            Spacer(modifier = Modifier.height(16.dp))

    // Texto para mostrar la ronda actual del juego.
            Text(
    // Muestra el texto "Ronda:" seguido del valor de la ronda actual.
                text = "Ronda: ${viewModel.datos.value.rondaActual}",
    // Estilo del texto.
                style = MaterialTheme.typography.headlineMedium
            )
    // Texto para mostrar la secuencia de botones que el jugador debe pulsar.
            Text(
    // Muestra la secuencia de botones.
                text = "Combinación a pulsar: ${viewModel.datos.value.secuenciaBotones.joinToString()}",
    // Estilo del texto.
                style = MaterialTheme.typography.bodyLarge
            )
    // Agrega un espacio vertical de 16 dp.
            Spacer(modifier = Modifier.height(16.dp))

    // Column para organizar los botones en una cuadrícula.
            Column(
    // Centra verticalmente los botones.
                verticalArrangement = Arrangement.Center,
    // Centra horizontalmente los botones.
                horizontalAlignment = Alignment.CenterHorizontally,
    // Ocupa el ancho disponible.
                modifier = Modifier.fillMaxWidth()
            ) {
    // Itera sobre los primeros 4 botones del enum Boton y crea un CustomButton para cada uno.
                Boton.entries.toTypedArray().take(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { viewModel.onButtonClicked(boton.numero) })
                }
            }
    // Row para organizar los botones restantes en una fila.
            Row(
    // Agrega un espacio de 16 dp entre los botones.
                horizontalArrangement = Arrangement.spacedBy(16.dp),
    // Ocupa el ancho disponible.
                modifier = Modifier.fillMaxWidth()
            ) {
    // Itera sobre los botones restantes del enum Boton y crea un CustomButton para cada uno.
                Boton.entries.drop(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { viewModel.onButtonClicked(boton.numero) })
                }
            }
    // Column para el botón Start y el mensaje
            Column(
                modifier = Modifier.fillMaxWidth(),
    // Ajusta según la separación deseada
                verticalArrangement = Arrangement.spacedBy(25.dp),
            ) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(16.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Boton_Start(onClick = { viewModel.generateSequence() })
                }
    // Texto para mostrar mensajes del juego
                Text(
                    text = viewModel.datos.value.mensaje,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}

    // Función Composable para crear un botón Start.
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

    // Función Composable para crear un botón personalizado.
@Composable
fun CustomButton(boton: Boton, onClick: () -> Unit) {
    Button(
    // Acción a realizar al pulsar el botón.
        onClick = onClick,
    // Color del botón.
        colors = ButtonDefaults.buttonColors(containerColor = boton.color),
        modifier = Modifier
    // Espacio inferior de 16 dp.
            .padding(bottom = 16.dp),
    ) {
    // Texto del botón.
        Text(text = "${boton.numero}", color = boton.textColor)
    }
}

    // Vista previa del diseño de botones.
@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
    UI()
}