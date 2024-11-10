package com.pmdm.example.botones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

// Clase principal de la actividad
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Establece el contenido de la actividad usando Jetpack Compose
        setContent {
            UI()

        }
    }
}


