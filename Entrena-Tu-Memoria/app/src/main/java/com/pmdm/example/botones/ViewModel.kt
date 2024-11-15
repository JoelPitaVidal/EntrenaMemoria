package com.pmdm.example.botones

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

// Clase ViewModel que maneja la lógica del juego "Simon Dice"
class ViewModel : ViewModel() {
    // Estado del juego, observable por la UI a través de mutableStateOf
    var datos = mutableStateOf(Datos())

    // Función que se llama cuando se pulsa un botón
    fun onButtonClicked(buttonNumber: Int) {
        // 1. Actualiza la secuencia de botones pulsados
        datos.value = Datos(
            aciertos = datos.value.aciertos,
            mostrarSioNo = datos.value.mostrarSioNo,
            fallos = datos.value.fallos,
            rondaActual = datos.value.rondaActual,
            secuenciaBotones = datos.value.secuenciaBotones + buttonNumber,
            botonesPulsados = datos.value.botonesPulsados,
            mensaje = datos.value.mensaje
        )

        // 2. Obtiene el índice del último botón pulsado
        val index = datos.value.secuenciaBotones.size - 1

        // 3. Comprueba si el botón pulsado es correcto
        if (datos.value.secuenciaBotones[index] == buttonNumber) {
            // 3.1. Si es correcto, actualiza el mensaje y los aciertos
            datos.value = Datos(
                aciertos = datos.value.aciertos + 1,
                mostrarSioNo = datos.value.mostrarSioNo,
                fallos = datos.value.fallos,
                rondaActual = datos.value.rondaActual,
                secuenciaBotones = datos.value.secuenciaBotones,
                botonesPulsados = datos.value.botonesPulsados,
                mensaje = "Los números son iguales"
            )
        } else {
            // 3.2. Si es incorrecto, actualiza el mensaje y los fallos
            datos.value = Datos(
                aciertos = datos.value.aciertos,
                mostrarSioNo = datos.value.mostrarSioNo,
                fallos = datos.value.fallos + 1,
                rondaActual = datos.value.rondaActual,
                secuenciaBotones = datos.value.secuenciaBotones,
                botonesPulsados = datos.value.botonesPulsados,
                mensaje = "Los números son diferentes"
            )
        }

        // 4. Comprueba si se ha completado la secuencia de 4 botones
        if (datos.value.secuenciaBotones.size == 4) {
            // 4.1. Si la secuencia es correcta, avanza a la siguiente ronda
            if (datos.value.secuenciaBotones == datos.value.botonesPulsados) {
                datos.value = Datos(
                    aciertos = datos.value.aciertos,
                    mostrarSioNo = datos.value.mostrarSioNo,
                    fallos = datos.value.fallos,
                    rondaActual = datos.value.rondaActual + 1,
                    secuenciaBotones = listOf(),
                    botonesPulsados = datos.value.botonesPulsados,
                    mensaje = "¡Ronda completada! Prepárate para la siguiente ronda."
                )
            } else {
                // 4.2. Si la secuencia es incorrecta, termina el juego
                datos.value = Datos(
                    aciertos = datos.value.aciertos,
                    mostrarSioNo = datos.value.mostrarSioNo,
                    fallos = datos.value.fallos,
                    rondaActual = datos.value.rondaActual,
                    secuenciaBotones = listOf(),
                    botonesPulsados = datos.value.botonesPulsados,
                    mensaje = "Juego terminado: \nHas llegado a la ronda ${datos.value.rondaActual}." +
                            "\nHas tenido un total de ${datos.value.aciertos} aciertos." +
                            "\nHas tenido un total de ${datos.value.fallos} fallos"
                )
            }
        }
    }

    // Función para generar una nueva secuencia de botones
    fun generateSequence(): List<Int> {
        // 1. Genera una lista de 4 números aleatorios entre 1 y 4
        val nuevaSecuencia = List(4) { Random.nextInt(1, 5) }
        // 2. Actualiza el estado con la nueva secuencia y mostrarSioNo en true
        datos.value = Datos(
            aciertos = datos.value.aciertos,
            mostrarSioNo = true,
            fallos = datos.value.fallos,
            rondaActual = datos.value.rondaActual,
            secuenciaBotones = nuevaSecuencia,
            botonesPulsados = datos.value.botonesPulsados,
            mensaje = datos.value.mensaje
        )
        // 3. Devuelve la nueva secuencia
        return nuevaSecuencia
    }
}