package com.pmdm.example.botones

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.pmdm.example.botones.Datos.ronda
import com.pmdm.example.botones.Datos.secuenciaIntroducida
import com.pmdm.example.botones.Datos.secuenciaGenerada
import com.pmdm.example.botones.Datos.mensajeMostrado
import com.pmdm.example.botones.Estados.*


class ViewModel : ViewModel() {
    var estadoActual: MutableLiveData<Estados> = MutableLiveData(ESPERANDO)

    private fun subirDeRonda() {
        ronda.value += 1
        Log.i("cicloVida", "Ronda aumentada")
    }

    fun generarSecuencia() {
        subirDeRonda()
        secuenciaGenerada.add((0..3).random())
        generandoNumeros()
        Log.i("cicloVida", "Secuencia generada: $secuenciaGenerada")
    }

    fun click(buttonId: Int, context: Context) {
        secuenciaIntroducida.add(buttonId)
        comprobarSecuencia(context)
    }

    private fun comprobarSecuencia(context: Context) {
        if (secuenciaGenerada == secuenciaIntroducida){
            secuenciaIntroducida.clear()
            Log.d("cicloVida", "Secuencia Correcta")
            establecerTexto("Ronda " + ronda.value + " superada")
            Toast.makeText(context, mensajeMostrado, Toast.LENGTH_SHORT).show()
            juegoEnEspera()
        }
        else if (secuenciaGenerada.subList(0, secuenciaIntroducida.size) == secuenciaIntroducida){
            Log.d("cicloVida", "Secuencia Correcta")
        }
        else{
            secuenciaIntroducida.clear()
            secuenciaGenerada.clear()
            ronda.value = 0
            Log.d("cicloVida", "Secuencia Inorrecta")
            establecerTexto("Ronda perdida :(")
            Toast.makeText(context, mensajeMostrado, Toast.LENGTH_SHORT).show()
            juegoEnEspera()
        }
    }

    private fun establecerTexto(text: String) {
        mensajeMostrado = text
        Log.d("cicloVida", "Mensaje mostrado: $mensajeMostrado")
    }

    private fun generandoNumeros() {
        estadoActual.value = GENERANDO
        Log.d("cicloVida", "Estado actual: Generando")
    }

    fun jugandoJuego() {
        estadoActual.value = JUGANDO
        Log.d("cicloVida", "Estado actual: Jugando")
    }

    private fun juegoEnEspera() {
        estadoActual.value = ESPERANDO
        Log.d("cicloVida", "Estado actual: Esperando")
    }
    companion object
}
