package com.pmdm.example.botones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pmdm.example.botones.ui.theme.SimonDiceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ViewModel = ViewModel()
        setContent {
            SimonDiceTheme {
                com.pmdm.example.botones.UI(model = viewModel)
            }
        }
    }
}

