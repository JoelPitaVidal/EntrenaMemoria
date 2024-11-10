package com.pmdm.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
// MainActivity.kt
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    val UI =UI()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
            // Iniciar la generación de un número aleatorio cuando el botón "Start" se presiona
            findViewById<Button>(R.id.startButton).setOnClickListener {
                UI.onClickStart()
            }
            // Comparar el número cuando el botón "Comparar" se presiona
            findViewById<Button>(R.id.compareButton).setOnClickListener {
                UI.onClickComparacion()
            }
            // Observar los cambios en el número aleatorio y mostrar un toast
            viewModel.numAleatorio.observe(this, Observer { num ->
                showToast(num.toString())
            })
            // Observar el resultado de la comparación y mostrar un toast
            viewModel.resultadoComparacion.observe(this, Observer { resultado ->
                showToast(resultado.toString())
            })
        }
    }


    private fun showToast(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }

}
