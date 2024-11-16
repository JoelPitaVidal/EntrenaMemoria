package com.pmdm.example.botones

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ViewModel : ViewModel() {
    var datos = mutableStateOf(Datos())

    fun onButtonClicked(buttonNumber: Int) {
        Log.i("cicloVida", "Botón pulsado: $buttonNumber")
        Log.i("cicloVida", "Secuencia antes del click: ${datos.value.secuenciaBotones}")
        Log.i("cicloVida", "Botones pulsados antes del click: ${datos.value.botonesPulsados}")

        // 1. Actualizar la secuencia de botones pulsados (del usuario)
        val nuevosBotonesPulsados = datos.value.botonesPulsados + buttonNumber
        datos.value = datos.value.copy(
            botonesPulsados = nuevosBotonesPulsados
        )

        val index = nuevosBotonesPulsados.size - 1

        // 3. Comprobar si el botón pulsado es correcto
        if (datos.value.secuenciaBotones.isNotEmpty() &&
            index < datos.value.secuenciaBotones.size &&
            datos.value.secuenciaBotones[index] == buttonNumber) {
            Log.i("cicloVida", "Boton pulsado correcto")
            // 3.1. Si es correcto, actualizar el mensaje y los aciertos
            datos.value = datos.value.copy(
                aciertos = datos.value.aciertos + 1,
                mensaje = "Los números son iguales"
            )
        } else if (datos.value.secuenciaBotones.isNotEmpty() &&
            index < datos.value.secuenciaBotones.size) {
            Log.i("cicloVida", "Los números son diferentes")
            // 3.2. Si es incorrecto, actualizar el mensaje y los fallos
            datos.value = datos.value.copy(
                fallos = datos.value.fallos + 1,
                mensaje = "Los números son diferentes"
            )
        }

        // 4. Comprobar si se ha completado la secuencia de 4 botones
        if (nuevosBotonesPulsados.size == 4) {
            if (datos.value.secuenciaBotones == nuevosBotonesPulsados) {
                Log.i("cicloVida", "Pasa de ronda")
                val nuevaSecuencia = generateSequence()
                datos.value = datos.value.copy(
                    rondaActual = datos.value.rondaActual + 1,
                    secuenciaBotones = nuevaSecuencia, // Nueva secuencia generada
                    botonesPulsados = listOf(),
                    mensaje = "¡Ronda completada! Prepárate para la siguiente ronda."
                )
            } else {
                Log.i("cicloVida", "Fin del juego")
                datos.value = datos.value.copy(
                    secuenciaBotones = listOf(),
                    botonesPulsados = listOf(),
                    mensaje = "Juego terminado: \nHas llegado a la ronda ${datos.value.rondaActual}." +
                            "\nHas tenido un total de ${datos.value.aciertos} aciertos." +
                            "\nHas tenido un total de ${datos.value.fallos} fallos"
                )
            }
        }

        Log.i("cicloVida", "Secuencia después del click: ${datos.value.secuenciaBotones}")
        Log.i("cicloVida", "Botones pulsados después del click: ${datos.value.botonesPulsados}")
    }

    fun generateSequence(): List<Int> {
        val nuevaSecuencia = List(4) { Random.nextInt(1, 5) }
        Log.i("cicloVida", "Secuencia de números generada: $nuevaSecuencia")
        datos.value = datos.value.copy(
            mostrarSioNo = true,
            secuenciaBotones = nuevaSecuencia,
            botonesPulsados = listOf() // Reiniciar botonesPulsados
        )
        return nuevaSecuencia
    }
}

