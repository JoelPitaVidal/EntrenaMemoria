package com.example.kotlinparaprincipiantes

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    /*
    Aqui vamos a hablar de variables y constantes
    */
    private fun variablesYConstantes(){
        //Variables
        var myFirstVariable = "Hello Hackermen!"
        var myFirstNumber = 1
        println(myFirstVariable)
        myFirstVariable = "Bienvenidos a Mouredev"
        println(myFirstVariable)
        //No es posible asignar un valor de tipo int a una variable String
        var mySecondVariable = "Hola buenas Tardes"
        println(mySecondVariable)
        mySecondVariable = myFirstVariable
        println(mySecondVariable)
        //Constantes
        var myFirstConstant = "Estoy viendo un tutorial"
        println(myFirstConstant)
        //Una constante noo puede modificar su valor

    }
}