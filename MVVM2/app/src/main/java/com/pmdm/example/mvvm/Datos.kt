package com.pmdm.example.mvvm

// Datos.kt
class Datos {

    private var numeroAleatorio: Int = 0

    fun setRandom(): Int {
        numeroAleatorio = (1..10).random() // Genera un número aleatorio entre 1 y 10
        return numeroAleatorio
    }

    fun getRandom(): Int {
        return numeroAleatorio
    }
}
