package com.pmdm.example.botones

// Clase para almacenar los diferentes datos del juego

data class Datos(
    var aciertos: Int = 0,
    var mostrarSioNo: Boolean = false,
    var fallos: Int = 0,
    var rondaActual: Int = 1,
    var secuenciaBotones: List<Int> = listOf(),
    var botonesPulsados: List<Int> = listOf(),
    var mensaje: String = ""
)