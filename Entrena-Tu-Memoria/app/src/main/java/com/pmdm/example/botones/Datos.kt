package com.pmdm.example.botones

// Clase para almacenar los diferentes datos del juego

data class Datos(
    var aciertos: Int = 0,
    var mostrarSioNo: Boolean = false,
    var fallos: Int = 0,
    var rondaActual: Int = 1,
    val secuenciaBotones: List<Int> = listOf(),
    val botonesPulsados: List<Int> = listOf(),
    val mensaje: String = ""
)