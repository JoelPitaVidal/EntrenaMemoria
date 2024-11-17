package com.pmdm.example.botones

    // Importaciones necesarias para la actividad y la UI de Compose.
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.pmdm.example.botones.ui.theme.SimonDiceTheme // Importa el tema de la aplicación.

    // Clase principal de la actividad de la aplicación.
class MainActivity : ComponentActivity() {
    // Función que se ejecuta al crear la actividad.
    override fun onCreate(savedInstanceState: Bundle?) {
    // Llama al metodo onCreate de la clase padre.
        super.onCreate(savedInstanceState)
    // Crea una instancia del ViewModel.
        val viewModel: ViewModel = ViewModel()
    // Define el contenido de la UI usando Jetpack Compose.
        setContent {
    // Aplica el tema de la aplicación.
            SimonDiceTheme {
    // Llama a la función UI para mostrar la interfaz de usuario del juego,
    // pasando la instancia del ViewModel como argumento.
                com.pmdm.example.botones.UI(model = viewModel)
            }
        }
    }
}