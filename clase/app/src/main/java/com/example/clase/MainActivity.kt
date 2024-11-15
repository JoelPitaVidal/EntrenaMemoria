import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp() {
    // Función que contiene la estructura de la UI
    MyStatefulButton()
}

@Composable
fun MyStatefulButton() {
    var text by remember { mutableStateOf("Presiona el botón") } // Variable de estado para almacenar el texto
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = CenterHorizontally
        ) {
            Text(text) // Muestra el texto almacenado en la variable de estado
            Spacer(modifier = Modifier.height(16.dp)) // Espacio entre el texto y el botón
    Button(onClick = {
    runCatching {
        // Operación que puede lanzar una excepción, por ejemplo:
        val result = 10 / 0  // División por cero para provocar una excepción
    }.onSuccess { result ->
        text = "Resultado exitoso: $result"
    }.onFailure { e ->
        text = "Error: ${e.message}"
    }
}) {
    Text("Pulsar")
}
        }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyStatefulButton()
}

