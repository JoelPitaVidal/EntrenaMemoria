package com.pmdm.example.botones

import android.util.Log
import androidx.activity.ComponentActivity

class CicloDeVida : ComponentActivity() {
    override fun onStart() {
        super.onStart()
        Log.i("cicloVida","Ingresa a onStart")
    }
    override fun onResume() {
        super.onResume()
        Log.i("cicloVida","Ingresa a onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i("cicloVida","Ingresa a onPause")
    }
    override fun onStop() {
        super.onStop()
        Log.i("cicloVida","Ingresa a onStop")
    }
    override fun onRestart() {
        super.onRestart()
        Log.i("cicloVida","Ingresa a onRestart")
    }
    override fun onDestroy() {
        super.onDestroy()
        Log.i("cicloVida","Ingresa a onDestroy")
    }
}
