package com.marisma.houseofthedragon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView


class ElectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_election)

        //obtener una referencia a la etiqueta de la actividad
        val tvGreeting = findViewById<TextView>(R.id.tvGreeting)

        //recogemos el nombre del intent
        val nombre = intent.getStringExtra("NAME")

        //declaramos las variables necesarias para controlar los eventos de los checkbox y del boton
        val checkBoxRhaenyra = findViewById<CheckBox>(R.id.checkBoxRhaenyra)
        val checkBoxAegon = findViewById<CheckBox>(R.id.checkBoxAegon)
        val eleccion = findViewById<TextView>(R.id.eleccion)
        val btRodilla = findViewById<Button>(R.id.btRodilla)

        //creamos la cadena del saludo
        tvGreeting.apply {
            //toma el valor de la cadena "greeting" y le incorpora el valor del nombre.
            text = getString(R.string.greeting,nombre)
        }

        checkBoxRhaenyra.setOnCheckedChangeListener { _, isChecked ->
            updateEleccion(checkBoxRhaenyra.isChecked, checkBoxAegon.isChecked, eleccion)
        }

        checkBoxAegon.setOnCheckedChangeListener { _, isChecked ->
            updateEleccion(checkBoxRhaenyra.isChecked, checkBoxAegon.isChecked, eleccion)
        }

        btRodilla.setOnClickListener {
            if ((checkBoxRhaenyra.isChecked && !checkBoxAegon.isChecked) || (!checkBoxRhaenyra.isChecked && checkBoxAegon.isChecked)){
                gotoFinal(checkBoxRhaenyra.isChecked, checkBoxAegon.isChecked)
            }
        }

    }

    private fun gotoFinal(isCheckBoxRhaenyraChecked: Boolean, isCheckBoxAegonChecked: Boolean) {
        //crear el intent
        val intent = Intent(this@ElectionActivity, FinalActivity::class.java)
        //dar el valor correspondiente al texto en funcion del sucesor elegido
        if(isCheckBoxRhaenyraChecked){
            intent.putExtra("SUCESOR", "Rhaenyra")
        }else{
            intent.putExtra("SUCESOR", "Aegon")
        }

        //iniciar la nueva actividad
        startActivity(intent)
    }

    private fun updateEleccion(isCheckBoxRhaenyraChecked: Boolean, isCheckBoxAegonChecked: Boolean, eleccion: TextView) {
        when {
            !isCheckBoxRhaenyraChecked && !isCheckBoxAegonChecked -> eleccion.text = "Si no tomas una decisión no podrás salir de esta encrucijada."
            isCheckBoxRhaenyraChecked && !isCheckBoxAegonChecked -> eleccion.text = "Has decidido apoyar a una mujer por encima del primogénito varón... Lo pagarás con sangre."
            !isCheckBoxRhaenyraChecked && isCheckBoxAegonChecked -> eleccion.text = "Has elegido a Aegon contra la voluntad del difunto rey... Arderás por tu elección... Dracarys!"
            isCheckBoxRhaenyraChecked && isCheckBoxAegonChecked -> eleccion.text = "Jugar a dos bandas es muy peligroso... Tu cabeza podrá rodar en cualquier momento."


        }
    }

}






