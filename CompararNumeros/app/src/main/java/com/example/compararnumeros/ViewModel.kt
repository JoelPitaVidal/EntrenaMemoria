package com.example.compararnumeros

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class NumeroViewModel : ViewModel() {
    private val _numeroMostrado = MutableLiveData<Int>()
    val numeroMostrado: LiveData<Int> get() = _numeroMostrado

    private val _mensaje = MutableLiveData<String>()
    val mensaje: LiveData<String> get() = _mensaje

    init {
        generarNuevoNumero()
    }

    fun generarNuevoNumero() {
        _numeroMostrado.value = Random.nextInt(1, 5)
    }

    fun comprobarNumero(numero: Int) {
        if (numero == _numeroMostrado.value) {
            _mensaje.value = "Los números son iguales"
        } else {
            _mensaje.value = "Los números son diferentes"
        }
    }
}
