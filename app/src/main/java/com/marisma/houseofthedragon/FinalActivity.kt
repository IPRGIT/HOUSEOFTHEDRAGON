package com.marisma.houseofthedragon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.system.exitProcess

class FinalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        //obtener una referencia a la etiqueta de la actividad
        val tvSucesor = findViewById<TextView>(R.id.tvSucesor)

        //recogemos el nombre del intent
        val nombreSucesor = intent.getStringExtra("SUCESOR")

        //creamos la cadena indicando al sucesor elegido
        tvSucesor.apply {
            //toma el valor de la cadena "greeting" y le incorpora el valor del nombre.
            text = getString(R.string.sucesor,nombreSucesor)
        }

        //intent para detectar si se ha pulsado salir.
        if(intent.getBooleanExtra("Exit",false))
            finish()

        //Enlace al botón e incorporación de evento "click".
        val btnAnswer = findViewById<Button>(R.id.btSalir)
        btnAnswer.setOnClickListener {
            finishAffinity()
        }
    }
}
