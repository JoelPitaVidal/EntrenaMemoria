package com.pmdm.example.botones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random


//Clase main
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val rondas = remember { Rondas() }
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(text = "Ronda: ${rondas.ronda}", style = MaterialTheme.typography.headlineMedium)
                Text(
                    text = "Combinación a pulsar: ${rondas.botonesQuePulsar.joinToString()}",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(16.dp))
                //Se asocia a un botón un número,que se guarda
                YellowButton(onClick = { rondas.onButtonClicked(1) })
                RedButton(onClick = { rondas.onButtonClicked(2) })
                BlueButton(onClick = { rondas.onButtonClicked(3) })
                GreenButton(onClick = { rondas.onButtonClicked(4) })
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = rondas.message, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}
//Clase con el código de las rondas
class Rondas {
    var ronda by mutableStateOf(1)
    var botonesQuePulsar by mutableStateOf(generateSequence())
    var message by mutableStateOf("")
    private val botonesPulsados = mutableListOf<Int>()

    fun onButtonClicked(buttonNumber: Int) {
        botonesPulsados.add(buttonNumber)
        if (botonesPulsados.size == 4) {
            if (botonesPulsados == botonesQuePulsar) {
                ronda++
                botonesQuePulsar = generateSequence()
                botonesPulsados.clear()
                message = "¡Ronda completada! Preparate para la siguiente ronda."
            } else {
                message = "Juego terminado. Has llegado a la ronda $ronda."
            }
        }
    }
    private fun generateSequence(): List<Int> {
        return List(4) { Random.nextInt(1, 5) }
    }
}

@Composable
fun YellowButton(onClick: () -> Unit) {
//Esta es la firma del boton que acepta un parámetro llamado onClick,
//que es una función que no toma argumentos y no devuelve nada.
//Este onClick define lo que ocurre cuando se presiona el botón.
    Button(
        //onClick: Define la acción que se ejecutará cuando se presione el botón.
        onClick = onClick,
        //Define los colores del botón usando ButtonDefaults
        colors = ButtonDefaults.buttonColors(containerColor = Color.Yellow),
        //Añade un modificador que,en este caso aplica un padding (espacio) en la parte inferior del botón de 16 dp.
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        //Dentro del botón, se incluye un componente Text que muestra un texto
        Text(text = "Botón Amarillo", color = Color.Black)
    }
}

@Composable
fun RedButton(onClick: () -> Unit) {
//Esta es la firma del boton que acepta un parámetro llamado onClick,
//que es una función que no toma argumentos y no devuelve nada.
// Este onClick define lo que ocurre cuando se presiona el botón.
    Button(
        //onClick: Define la acción que se ejecutará cuando se presione el botón.
        onClick = onClick,
        //Define los colores del botón usando ButtonDefaults
        colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
        //Añade un modificador que,en este caso aplica un padding (espacio) en la parte inferior del botón de 16 dp.
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        //Dentro del botón, se incluye un componente Text que muestra un texto
        Text(text = "Botón Rojo", color = Color.White)
    }
}

@Composable
fun BlueButton(onClick: () -> Unit) {
//Esta es la firma del boton que acepta un parámetro llamado onClick,
//que es una función que no toma argumentos y no devuelve nada.
// Este onClick define lo que ocurre cuando se presiona el botón.
    Button(
        //onClick: Define la acción que se ejecutará cuando se presione el botón.
        onClick = onClick,
        //Define los colores del botón usando ButtonDefaults
        colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
        //Añade un modificador que,en este caso aplica un padding (espacio) en la parte inferior del botón de 16 dp.
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        //Dentro del botón, se incluye un componente Text que muestra un texto
        Text(text = "Botón Azul", color = Color.White)
    }
}

@Composable
fun GreenButton(onClick: () -> Unit) {
//Esta es la firma del boton que acepta un parámetro llamado onClick,
//que es una función que no toma argumentos y no devuelve nada.
// Este onClick define lo que ocurre cuando se presiona el botón.
    Button(
        //onClick: Define la acción que se ejecutará cuando se presione el botón.
        onClick = onClick,
        //Define los colores del botón usando ButtonDefaults
        colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
        //Añade un modificador que,en este caso aplica un padding (espacio) en la parte inferior del botón de 16 dp.
        modifier = Modifier
            .padding(bottom = 16.dp)
    ) {
        //Dentro del botón, se incluye un componente Text que muestra un texto
        Text(text = "Botón Verde", color = Color.White)
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewButtons() {
//Esta anotación indica que la función PreviewButtons
//es una vista previa en Jetpack Compose. showBackground = true
//muestra el fondo detrás de los componentes para tener una mejor
//idea de cómo se verá en la aplicación.
    val rondas = Rondas()
    Column(
        //Modifica el contenedor para que llene el tamaño disponible y añade un padding de 16 dp.
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        //Centra verticalmente los componentes hijos dentro de la columna.
        verticalArrangement = Arrangement.Center,
        //Alinea los componentes hijos a la derecha.
        horizontalAlignment = Alignment.End
    ) {
        //Llama a la función de su botón y define su comportamiento onClick,
        //que añade el número concreto a la lista de botones pulsados en la clase Rondas.
        YellowButton(onClick = { rondas.onButtonClicked(1) })
        RedButton(onClick = { rondas.onButtonClicked(2) })
        BlueButton(onClick = { rondas.onButtonClicked(3) })
        GreenButton(onClick = { rondas.onButtonClicked(4) })
    }
}



