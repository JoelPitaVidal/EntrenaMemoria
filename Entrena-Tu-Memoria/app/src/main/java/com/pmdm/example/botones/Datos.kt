package com.pmdm.example.botones

// Clase para almacenar los diferentes datos del juego
class Datos(
    var aciertos: Int = 0, // Contador de aciertos
    var mostrarSioNo: Boolean = false,//Indica si debe mostrarse la lista de números
    var fallos: Int = 0, // Contador de fallos
    var rondaActual: Int = 1, // Ronda actual
    var secuenciaBotones: List<Int> = listOf(), // Lista de botones que se deben pulsar en la ronda actual
    var botonesPulsados: List<Int> = listOf(), //Lista de los botones que se  han pulsado
    var mensaje: String = "" // Mensaje para mostrar al usuario
)

