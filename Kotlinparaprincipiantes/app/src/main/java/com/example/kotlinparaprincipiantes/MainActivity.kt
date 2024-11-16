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
        tiposDeDatos()
        sentenciaIF()
    }
    private fun tiposDeDatos() {
        //Strig

        val myString :String= "Hola Hackermen"
        val mySecondString :String= "Bienvenidos a android"
        val myThirdString :String= myString + " " + mySecondString
        println(myThirdString)

        //Enteros (Byte, Short, Int ,Long)
        val myInt: Int  = 1
        val myInt2 = 2
        val myInt3: Int = myInt + myInt2
        println(myInt3)

        //Decimales (Float, Double)
        val myFloat: Float = 1.5f
        val myDouble: Double = 1.5
        val myDouble2: Double = 2.5
        val myDouble3: Double = 1.0
        val myDouble4: Double = myDouble  + myDouble2 + myDouble3

        //Booleanos
        val myBool: Boolean = true
        val myBool2 = false
        //val myBool3 = myBool + myBool2
    }

    //Sentencia IF

    private fun sentenciaIF() {

        val myNumber = 10
        // < menor que
        // > mayor que
        // <= menor o igual que
        // >= mayor o igual que
        // == igual que
        // != diferente a
        // && operador "y"
        // || operador "o"
        // ! operador "no"

        if (myNumber < 10 && myNumber > 5) {
            println("$myNumber es menor o igual que 10 y mayor que 5")
        }else
            println("$myNumber es mayor a 10 o menor que 5")


      fun  variablesYConstantes(){

      var myFirstVariable = "Texto de ejemplo"

         println(myFirstVariable)

      myFirstVariable = "Bienvenidos a android"

         println(myFirstVariable)
      //No se puede asignar un número como valor a una variable tipo cadena de texto
      //myFirstVariable = 1 --> produce un error al ejecutar


      //De esta forma establecemos una variable como constante
      val myFirstConstant = "Segundo ejemplo"
      //Estas no pueden modificar su valor

      val mySecondConstant = myFirstVariable
     }
        //Aqui vamos a hablar de la sentencia when
    fun sentenciaWhen(){
        //when con string
         val country = "España"
         when(country){
                "España", "Mexico", "Perú", "Colombia", "Argentina" -> {
             println("El idioma es español")
                }"EEUU" -> {
             println("El idioma es Inglés")
                }"Francia" -> {
             println("El idioma es Francés")
                }else -> {
             println("No conocemos el idioma")
                }

            }
            val age = 10
            when(age){
                0,1,2 -> {

                }in 3..10 -> {

                }in 18..69 -> {

                }in 70..99 -> {

                }

            }
        }
        fun array(){
            val name = "Yoel"
            val surname = "Pita"
            val age = "21"
            val country = "España"
            //Creamos el array
            val myArray = arrayListOf<String>()
            //Añadir datos
            myArray.add(name)
            myArray.add(surname)
            myArray.add(age)
            myArray.add(country)
        }
    }
}