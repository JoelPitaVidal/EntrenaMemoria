package com.pmdm.example.botones

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class ViewModel : ViewModel() {
    var datos = mutableStateOf(Datos())

    fun onButtonClicked(buttonNumber: Int) {
        // 1. Actualizar la secuencia de botones pulsados (del usuario)
        datos.value = Datos(
            aciertos = datos.value.aciertos,
            mostrarSioNo = datos.value.mostrarSioNo,
            fallos = datos.value.fallos,
            rondaActual = datos.value.rondaActual,
            secuenciaBotones = datos.value.secuenciaBotones, // La secuencia del juego NO se modifica
            botonesPulsados = datos.value.botonesPulsados + buttonNumber, // Agregar el botón a la secuencia del usuario
            mensaje = datos.value.mensaje
        )
        // Índice para la secuencia del usuario
        val index = datos.value.botonesPulsados.size - 1

        // 3. Comprobar si el botón pulsado es correcto
        if (datos.value.secuenciaBotones.isNotEmpty() &&  // Verificar si hay una secuencia objetivo
            index < datos.value.secuenciaBotones.size && // Verificar que el índice esté dentro de los límites
            datos.value.secuenciaBotones[index] == buttonNumber) {
            Log.i("cicloVida", "Boton pulsado correcto")
        // 3.1. Si es correcto, actualizar el mensaje y los aciertos
            datos.value = Datos(
                aciertos = datos.value.aciertos + 1,
        // ... (resto de las propiedades) ...
                mensaje = "Los números son iguales"
            )
        // Verificar si hay una secuencia objetivo
        } else if (datos.value.secuenciaBotones.isNotEmpty() &&
        // Verificar que el índice esté dentro de los límites
            index < datos.value.secuenciaBotones.size){
            Log.i("cicloVida", "hay secuencia objetivo")
        // 3.2. Si es incorrecto, actualizar el mensaje y los fallos
            datos.value = Datos(
        // ... (resto de las propiedades) ...
                fallos = datos.value.fallos + 1,
                mensaje = "Los números son diferentes"
            )
        }

        // 4. Comprobar si se ha completado la secuencia de 4 botones
        // Verificar con la secuencia del usuario
        if (datos.value.botonesPulsados.size == 4) {
            if (datos.value.secuenciaBotones == datos.value.botonesPulsados) {
        // ... (lógica para la siguiente ronda) ...
                Log.i("cicloVida", "Pasa de ronda")
                datos.value = datos.value.copy(
                    rondaActual = datos.value.rondaActual + 1,
                    secuenciaBotones = listOf(),
                    botonesPulsados = listOf(),
                    mensaje = "¡Ronda completada! Prepárate para la siguiente ronda."
                )
            } else {
        // ... (lógica para el final del juego) ...
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
    }


    fun generateSequence(): List<Int> {
        val nuevaSecuencia = List(4) { Random.nextInt(1, 5) }
        Log.i("cicloVida", "Secuencia de numeros generada")
        datos.value = Datos(
            aciertos = datos.value.aciertos,
            mostrarSioNo = true,
            fallos = datos.value.fallos,
            rondaActual = datos.value.rondaActual,
        // Asignar la nueva secuencia
            secuenciaBotones = nuevaSecuencia,
        // Reiniciar la secuencia del usuario
            botonesPulsados = listOf(),
            mensaje = datos.value.mensaje
        )
        return nuevaSecuencia
    }
}