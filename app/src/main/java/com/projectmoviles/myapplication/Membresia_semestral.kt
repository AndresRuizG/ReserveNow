package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_membresia_mensual.*
import kotlinx.android.synthetic.main.activity_membresia_semestral.*

class Membresia_semestral : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_semestral)

        btnDerechaSemestral.setOnClickListener {
            val intent = Intent(this, Membresia_anual::class.java)
            startActivity(intent)
        }
        btnIzquierdaSemestral.setOnClickListener {
            val intent = Intent(this, Membresia_mensual::class.java)
            startActivity(intent)
        }
        btnSemestralRetornoHomeMembresia.setOnClickListener {
            val intent = Intent(this, Membresia::class.java)
            startActivity(intent)
        }
        btnComprarSemestral.setOnClickListener {
            Toast.makeText(this, "Usted ha comprado un pase semestral", Toast.LENGTH_SHORT).show()
        }
    }
}