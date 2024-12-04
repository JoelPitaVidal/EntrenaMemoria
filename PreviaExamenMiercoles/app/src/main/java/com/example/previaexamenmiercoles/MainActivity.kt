package com.example.previaexamenmiercoles

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.previaexamenmiercoles.ui.theme.PreviaExamenMiercolesTheme
import com.example.previaexamenmiercoles.view.MyApp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PreviaExamenMiercolesTheme {
                MyApp(viewModel)
            }
        }
    }
}
