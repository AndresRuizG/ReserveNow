package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_membresia_diaria.*
import kotlinx.android.synthetic.main.activity_membresia_mensual.*

class Membresia_mensual : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_mensual)
        btnDerechaMensual.setOnClickListener {
            intent = Intent(this, Membresia_semestral::class.java)
            startActivity(intent)
        }
        btnIzquierdaMensual.setOnClickListener {
            intent = Intent(this, Membresia_diaria::class.java)
            startActivity(intent)
        }
        btnMensualRetornoHomeMembresia.setOnClickListener {
            intent = Intent(this, Membresia::class.java)
            startActivity(intent)
        }
        btnComprarMensual.setOnClickListener {
            Toast.makeText(this, MENSAJE_COMPRA_PASE_MENSUAL, Toast.LENGTH_SHORT).show()
        }
    }
}