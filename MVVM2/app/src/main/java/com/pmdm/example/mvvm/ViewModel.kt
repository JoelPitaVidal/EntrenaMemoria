package com.pmdm.example.mvvm

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

// MyViewModel.kt
class MyViewModel : ViewModel() {

    private val datos = Datos()

    // LiveData para observar el número aleatorio generado
    val numAleatorio: MutableLiveData<Int> = MutableLiveData()

    // LiveData para observar el resultado de la comparación
    val resultadoComparacion: MutableLiveData<Boolean> = MutableLiveData()

    fun start() {
        val randomNum = datos.setRandom()
        numAleatorio.value = randomNum
    }

    fun comparacion(valor: Int) {
        val resultado = datos.getRandom() == valor
        resultadoComparacion.value = resultado
    }
}
