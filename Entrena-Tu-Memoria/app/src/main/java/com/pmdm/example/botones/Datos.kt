package com.pmdm.example.botones

import androidx.compose.ui.graphics.Color
import androidx.compose.runtime.mutableStateOf

object Datos {
    var ronda = mutableStateOf(0)
    val secuenciaGenerada = mutableListOf<Int>()
    val secuenciaIntroducida = mutableListOf<Int>()
    var mensajeMostrado = ""

}

enum class Colors (val id: Int, val nombre: String, val color: Color, val colorPressed: Color){
    RED(0, "Red", Color(0xFFE57373), Color(0xFFB71C1C)),
    BLUE(1, "Blue", Color(0xFF64B5F6), Color(0xFF0D47A1)),
    GREEN(2, "Green", Color(0xFF81C784), Color(0xFF1B5E20)),
    YELLOW(3, "Yellow", Color(0xFFFFF176), Color(0xFFF57F17));
}

enum class Estados(val start_activo: Boolean, val boton_activo: Boolean) {
    ESPERANDO(start_activo = true, boton_activo = false),
    GENERANDO(start_activo = false, boton_activo = false),
    JUGANDO(start_activo = false, boton_activo = true),
}