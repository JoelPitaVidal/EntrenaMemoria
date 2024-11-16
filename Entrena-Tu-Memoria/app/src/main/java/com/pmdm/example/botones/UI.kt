package com.pmdm.example.botones

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

    // Box se utiliza para superponer elementos. En este caso, se usa para colocar la imagen de fondo (si la hubiera).
    Box(
        modifier = Modifier
            .fillMaxSize() // El modificador fillMaxSize() hace que el Box ocupe el espacio disponible en la pantalla.
    ) {
        // Column se utiliza para organizar elementos verticalmente.
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa el tamaño de la pantalla.
                .padding(16.dp), // Agrega un padding de 16 dp alrededor de la columna.
            verticalArrangement = Arrangement.Center, // Centra verticalmente los elementos dentro de la columna.
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente los elementos dentro de la columna.
        ) {
            // Box para contener el título del juego.
            Box(modifier = Modifier.fillMaxWidth()) { // fillMaxWidth() hace que el Box ocupe el ancho disponible.
                Text(
                    text = "Simon dice", // Texto del título.
                    style = MaterialTheme.typography.headlineMedium, // Estilo del texto del título.
                    modifier = Modifier.align(Alignment.TopCenter) // Alinea el texto en el centro superior del Box.
                )
            }
            Spacer(modifier = Modifier.height(16.dp)) // Agrega un espacio vertical de 16 dp.

            // Texto para mostrar la ronda actual del juego.
            Text(
                text = "Ronda: ${viewModel.datos.value.rondaActual}", // Muestra el texto "Ronda:" seguido del valor de la ronda actual.
                style = MaterialTheme.typography.headlineMedium // Estilo del texto.
            )
            // Texto para mostrar la secuencia de botones que el jugador debe pulsar.
            Text(
                text = "Combinación a pulsar: ${viewModel.datos.value.secuenciaBotones.joinToString()}", // Muestra la secuencia de botones.
                style = MaterialTheme.typography.bodyLarge // Estilo del texto.
            )
            Spacer(modifier = Modifier.height(16.dp)) // Agrega un espacio vertical de 16 dp.

            // Column para organizar los botones en una cuadrícula.
            Column(
                verticalArrangement = Arrangement.Center, // Centra verticalmente los botones.
                horizontalAlignment = Alignment.CenterHorizontally, // Centra horizontalmente los botones.
                modifier = Modifier.fillMaxWidth() // Ocupa el ancho disponible.
            ) {
                // Itera sobre los primeros 4 botones del enum Boton y crea un CustomButton para cada uno.
                Boton.entries.toTypedArray().take(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { viewModel.onButtonClicked(boton.numero) })
                }
            }
            // Row para organizar los botones restantes en una fila.
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp), // Agrega un espacio de 16 dp entre los botones.
                modifier = Modifier.fillMaxWidth() // Ocupa el ancho disponible.
            ) {
                // Itera sobre los botones restantes del enum Boton y crea un CustomButton para cada uno.
                Boton.entries.drop(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { viewModel.onButtonClicked(boton.numero) })
                }
            }
            // Column para el botón Start y el mensaje
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(25.dp), // Ajusta según la separación deseada
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
        Text(text = "Start", color = Color.Black)
    }
}

// Función Composable para crear un botón personalizado.
@Composable
fun CustomButton(boton: Boton, onClick: () -> Unit) {
    Button(
        onClick = onClick, // Acción a realizar al pulsar el botón.
        colors = ButtonDefaults.buttonColors(containerColor = boton.color), // Color del botón.
        modifier = Modifier
            .padding(bottom = 16.dp), // Espacio inferior de 16 dp.
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