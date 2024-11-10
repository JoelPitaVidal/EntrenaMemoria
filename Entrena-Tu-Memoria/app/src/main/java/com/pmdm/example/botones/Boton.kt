package com.pmdm.example.botones

import androidx.compose.ui.graphics.Color

//Clase enum con los datos de los cuatro botones diferentes
enum class Boton(val numero: Int, val color: Color, val textColor: Color) {
    AMARILLO(1, Color.Yellow, Color.Black),
    ROJO(2, Color.Red, Color.White),
    AZUL(3, Color.Blue, Color.White),
    VERDE(4, Color.Green, Color.White)
}
