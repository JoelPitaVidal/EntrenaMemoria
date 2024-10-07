package com.pmdm.example.botones
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                .fillMaxSize() // Llena toda la pantalla verticalmente
                .padding(16.dp),
                verticalArrangement = Arrangement.Center, // Centra verticalmente los botones
                horizontalAlignment = Alignment.End // Alinea todos los hijos a la derecha
            ) {
                YellowButton()
                RedButton()
                BlueButton()
                GreenButton()
            }
        }
    }
}

@Composable
fun YellowButton() {
    Button(
        onClick = { /* Acción del botón */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow), // Fondo amarillo
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Text(text = "Botón Amarillo", color = Color.Black)
    }
}

@Composable
fun RedButton() {
    Button(
        onClick = { /* Acción del botón */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red), // Fondo rojo
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Text(text = "Botón Rojo", color = Color.White)
    }
}

@Composable
fun BlueButton() {
    Button(
        onClick = { /* Acción del botón */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue), // Fondo azul
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Text(text = "Botón Azul", color = Color.White)
    }
}

@Composable
fun GreenButton() {
    Button(
        onClick = { /* Acción del botón */ },
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green), // Fondo verde
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        Text(text = "Botón Verde", color = Color.White)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.End // Alinea los hijos a la derecha
    ) {
        YellowButton()
        RedButton()
        BlueButton()
        GreenButton()
    }
}

@Composable
fun simonDice(){
    var botonApulsar by remember {
        var random
    }
    Column (

        ){
        Text(text = "Simón dice: Pulsar el botón ~$botonApulsar", color = Color.White)
    }

}