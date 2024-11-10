package com.pmdm.example.botones

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Composable principal de la aplicación
@Composable
fun UI(ViewModel: ViewModel = ViewModel()) {
    // Estructura de diseño usando Box para superponer la imagen de fondo
    Box(
        modifier = Modifier
            .fillMaxSize() // Ocupa  el tamaño de la pantalla
    ) {
        // Imagen de fondo
        //        Image(
        //            painter = painterResource(R.drawable.background_image), // Referencia a la imagen en la carpeta drawable
        //            contentDescription = null,
        //            modifier = Modifier.fillMaxSize() // La imagen ocupa  el tamaño de la pantalla
        //        )


        // Estructura de diseño usando Column
        Column(
            modifier = Modifier
                .fillMaxSize() // Ocupa  el tamaño de la pantalla
                .padding(16.dp), // Padding alrededor de la columna
            verticalArrangement = Arrangement.Center, // Centra verticalmente los elementos dentro de la columna
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente los elementos dentro de la columna
        ) {
            // Caja para contener el título
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Entrena tu memoria", // Texto del título
                    style = MaterialTheme.typography.headlineMedium, // Estilo del texto
                    modifier = Modifier.align(Alignment.TopCenter) // Alinea el texto en el centro superior de la caja
                )
            }
            Spacer(modifier = Modifier.height(16.dp)) // Espacio de 16 dp de altura
            // Texto para mostrar la ronda actual
            Text(
                text = "Ronda: ${ViewModel.Datos.value.rondaActual}",
                style = MaterialTheme.typography.headlineMedium
            )
            // Texto para mostrar la combinación de botones a pulsar
            Text(
                text = "Combinación a pulsar: ${ViewModel.Datos.value.secuenciaBotones.joinToString()}",
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.height(16.dp)) // Espacio de 16 dp de altura

            // Crear la cuadrícula de botones
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                // Botones de la primera fila
                Boton.values().take(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { ViewModel.onButtonClicked(boton.numero) })
                }
            }
            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp), // Espacia los botones horizontalmente con 16 dp
                modifier = Modifier.fillMaxWidth() // Ocupa  el ancho disponible
            ) {
                // Botones de la segunda fila
                Boton.values().drop(4).forEach { boton ->
                    CustomButton(boton = boton, onClick = { ViewModel.onButtonClicked(boton.numero) })
                }
            }

            Spacer(modifier = Modifier.height(16.dp)) // Espacio de 16 dp de altura
            // Texto para mostrar mensajes del juego
            Text(text = ViewModel.Datos.value.mensaje, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

// Composable para crear un botón personalizado
@Composable
fun CustomButton(boton: Boton, onClick: () -> Unit) {
    Button(
        onClick = onClick, // Acción a realizar al pulsar el botón
        colors = ButtonDefaults.buttonColors(containerColor = boton.color), // Color del botón
        modifier = Modifier
            .padding(bottom = 16.dp) // Espacio inferior de 16 dp
    ) {
        // Texto del botón
        Text(text = "${boton.numero}", color = boton.textColor)
    }
}

// Vista previa del diseño de botones
@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
    UI()
}
