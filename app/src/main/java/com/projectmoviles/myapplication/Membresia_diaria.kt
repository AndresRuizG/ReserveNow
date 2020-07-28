package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_membresia_diaria.*

class Membresia_diaria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_diaria)
        btnDerechaDiario.setOnClickListener {
            val intent = Intent(this, Membresia_mensual::class.java)
            startActivity(intent)
        }

        btnHomeMembresia.setOnClickListener {
            val intent = Intent(this, Membresia::class.java)
            startActivity(intent)
        }
        btnComprarDiario.setOnClickListener {
            Toast.makeText(this, "Usted ha comprado un pase diario", Toast.LENGTH_SHORT).show()
        }
    }
}