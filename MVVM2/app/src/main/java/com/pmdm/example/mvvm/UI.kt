package com.pmdm.example.mvvm

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class UI{

    private lateinit var viewModel: MyViewModel


     fun onClickStart() {
        viewModel.start()
    }

     fun onClickComparacion() {
        viewModel.comparacion(5) // Aquí 5 es un valor ejemplo para la comparación
    }

}