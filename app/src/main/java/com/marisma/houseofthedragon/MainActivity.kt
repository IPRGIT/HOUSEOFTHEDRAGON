package com.marisma.houseofthedragon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Intent para detectar si se ha pulsado salir.
        if (intent.getBooleanExtra("Exit", false))
            finish()

        // Enlace a los componentes de la UI.
        val btnAnswer = findViewById<Button>(R.id.btnAnswer)
        val etNombre = findViewById<EditText>(R.id.etName)

        // Asigna el evento "click" al botón.
        btnAnswer.setOnClickListener {
            // Verifica si el campo de texto está vacío o contiene el texto establecido en el layout "Name".
            if (etNombre.text.toString().isEmpty() || etNombre.text.toString() == "Name") {
                // Muestra un Toast con el mensaje de alerta.
                Toast.makeText(this, getString(R.string.alerta), Toast.LENGTH_SHORT).show()
            } else {
                // Llama a la función para ir a la siguiente actividad.
                goToElection()
            }
        }
    }

    fun goToElection() {
        // Crear el intent.
        val intent = Intent(this@MainActivity, ElectionActivity::class.java)
        // Tomar el valor del cuadro de texto.
        val etNombre = this.findViewById<EditText>(R.id.etName)
        // Añade la información necesaria al intent.
        intent.putExtra("NAME", etNombre.text.toString())
        // Iniciar la nueva actividad.
        startActivity(intent)
    }

    companion object {
        const val LIFECLICLE = "LifeCycle"
    }

    // Métodos de ciclo de vida de la actividad.
    override fun onRestart() {
        super.onRestart()
        Log.d(LIFECLICLE, "La Activity ha sido reiniciada (Restarted)")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LIFECLICLE, "La Activity ha sido iniciada (Started)")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LIFECLICLE, "La Activity ha pasado a primer plano (Resumed)")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LIFECLICLE, "La Activity ha sido pausada (Paused)")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LIFECLICLE, "La Activity ha sido parada (Stopped)")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LIFECLICLE, "La Activity ha sido destruida (Destroyed)")
    }
}
