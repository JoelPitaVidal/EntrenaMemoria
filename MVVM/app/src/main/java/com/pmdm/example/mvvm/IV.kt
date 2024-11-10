package com.pmdm.example.mvvm

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

class IV {

}

enum class Boton(val numero: Int, val color: Color, val textColor: Color) {
    AMARILLO(1, Color.Yellow, Color.Black),
    ROJO(2, Color.Red, Color.White),
    AZUL(3, Color.Blue, Color.White),
    VERDE(4, Color.Green, Color.White)
}

@Composable
fun CustomButton(boton: Boton, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = boton.color),
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Text(text = "Botón ${boton.name}", color = boton.textColor)
    }
}