package com.pmdm.example.botones

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ViewModel : ViewModel() {
    var datos = mutableStateOf(Datos())

    fun onButtonClicked(buttonNumber: Int) {
        // 1. Actualizar la secuencia de botones pulsados
        datos.value = Datos(
            aciertos = datos.value.aciertos,
            mostrarSioNo = datos.value.mostrarSioNo,
            fallos = datos.value.fallos,
            rondaActual = datos.value.rondaActual,
            secuenciaBotones = datos.value.secuenciaBotones + buttonNumber,
            botonesPulsados = datos.value.botonesPulsados,
            mensaje = datos.value.mensaje // Conservar el mensaje actual
        )

        val index = datos.value.secuenciaBotones.size - 1

        // 3. Comprobar si el botón pulsado es correcto
        if (datos.value.secuenciaBotones[index] == buttonNumber) {
            // 3.1. Si es correcto, actualizar el mensaje y los aciertos
            datos.value = Datos(
                aciertos = datos.value.aciertos + 1,
                mostrarSioNo = datos.value.mostrarSioNo,
                fallos = datos.value.fallos,
                rondaActual = datos.value.rondaActual,
                secuenciaBotones = datos.value.secuenciaBotones,
                botonesPulsados = datos.value.botonesPulsados,
                mensaje = "Los números son iguales" // Actualizar el mensaje
            )
        } else {
            // 3.2. Si es incorrecto, actualizar el mensaje y los fallos
            datos.value = Datos(
                aciertos = datos.value.aciertos,
                mostrarSioNo = datos.value.mostrarSioNo,
                fallos = datos.value.fallos + 1,
                rondaActual = datos.value.rondaActual,
                secuenciaBotones = datos.value.secuenciaBotones,
                botonesPulsados = datos.value.botonesPulsados,
                mensaje = "Los números son diferentes" // Actualizar el mensaje
            )
        }

        // 4. Comprobar si se ha completado la secuencia de 4 botones
        if (datos.value.secuenciaBotones.size == 4) {
            // Comparar la secuencia pulsada con la secuencia objetivo
            if (datos.value.secuenciaBotones == datos.value.botonesPulsados) {
                datos.value = Datos(
                    aciertos = datos.value.aciertos,
                    mostrarSioNo = datos.value.mostrarSioNo,
                    fallos = datos.value.fallos,
                    rondaActual = datos.value.rondaActual + 1,
                    secuenciaBotones = listOf(),
                    botonesPulsados =  listOf(), // Reiniciar botonesPulsados para la siguiente ronda
                    mensaje = "¡Ronda completada! Prepárate para la siguiente ronda."
                )
            } else {
                datos.value = Datos(
                    aciertos = datos.value.aciertos,
                    mostrarSioNo = datos.value.mostrarSioNo,
                    fallos = datos.value.fallos,
                    rondaActual = datos.value.rondaActual,
                    secuenciaBotones = listOf(),
                    botonesPulsados = listOf(), // Reiniciar botonesPulsados
                    mensaje = "Juego terminado: \nHas llegado a la ronda ${datos.value.rondaActual}." +
                            "\nHas tenido un total de ${datos.value.aciertos} aciertos." +
                            "\nHas tenido un total de ${datos.value.fallos} fallos"
                )
            }
        }
    }

    fun generateSequence(): List<Int> {
        val nuevaSecuencia = List(4) { Random.nextInt(1, 5) }
        datos.value = Datos(
            aciertos = datos.value.aciertos,
            mostrarSioNo = true,
            fallos = datos.value.fallos,
            rondaActual = datos.value.rondaActual,
            secuenciaBotones = nuevaSecuencia,
            botonesPulsados =  listOf(),// Reiniciar botonesPulsados para la nueva secuencia
            mensaje = datos.value.mensaje // Conservar el mensaje actual
        )
        return nuevaSecuencia
    }
}