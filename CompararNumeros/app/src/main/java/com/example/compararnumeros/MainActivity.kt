import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@Composable
fun MyApp(boton: Boton, onClick: () -> Unit) {

    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = boton.color),
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Text(text = "Botón ${boton.name}", color = boton.textColor)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}

enum class Boton(val numero: Int, val color: Color, val textColor: Color) {
    AMARILLO(1, Color.Yellow, Color.Black),
    ROJO(2, Color.Red, Color.White),
    AZUL(3, Color.Blue, Color.White),
    VERDE(4, Color.Green, Color.White)
}
