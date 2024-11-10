package com.pmdm.example.botones

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ViewModel : ViewModel() {
    var Datos= mutableStateOf(Datos()) // Instancia de la clase Datos para almacenar el estado del juego

    // Función que se llama cuando se pulsa un botón
    fun onButtonClicked(buttonNumber: Int) {

        val datosActuales = Datos.value

        // Añadir el número pulsado a la lista de botones pulsados
        datosActuales.secuenciaBotones = datosActuales.secuenciaBotones + buttonNumber

        // Obtener el índice del botón pulsado
        val index = datosActuales.secuenciaBotones.size - 1

        // Comprobar si el número pulsado coincide con el número en la secuencia
        if (datosActuales.secuenciaBotones[index] == buttonNumber) {
            datosActuales.mensaje = "Los números son iguales" // Mensaje de acierto
            datosActuales.aciertos++ // Incrementar contador de aciertos
        } else {
            datosActuales.mensaje = "Los números son diferentes" // Mensaje de error
            datosActuales.fallos++ // Incrementar contador de fallos
        }

        // Comprobar si se han pulsado 4 botones
        if (datosActuales.secuenciaBotones.size == 4) {
            if (datosActuales.secuenciaBotones == datosActuales.secuenciaBotones) {
                datosActuales.rondaActual++ // Incrementar contador de rondas
                datosActuales.secuenciaBotones = generateSequence() // Generar una nueva secuencia de botones
                datosActuales.mensaje = "¡Ronda completada! Prepárate para la siguiente ronda." // Mensaje de ronda completada
            } else {
                datosActuales.mensaje = "Juego terminado: \nHas llegado a la ronda ${datosActuales.rondaActual}.\nHas tenido un total de ${datosActuales.aciertos} aciertos.\nHas tenido un total de ${datosActuales.fallos} fallos" // Mensaje de fin del juego
            }
            datosActuales.secuenciaBotones = listOf() // Limpiar la lista de botones pulsados
        }

        Datos.value = datosActuales // Actualizar los datos en el estado
    }

    // Función para generar una secuencia aleatoria de 4 números entre 1 y 4
    private fun generateSequence(): List<Int> {
        return List(4) { Random.nextInt(1, 5)
        }
    }
}

