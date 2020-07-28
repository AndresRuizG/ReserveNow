package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projectmoviles.myapplication.MENSAJE_COMPRA_PASE_SEMESTRAL
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_semestral.*

class Membresia_semestral : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_semestral)
        btnDerechaSemestral.setOnClickListener {
            intent=Intent(this, Membresia_anual::class.java)
            startActivity(intent)
        }
        btnIzquierdaSemestral.setOnClickListener {
            intent=Intent(this, Membresia_mensual::class.java)
            startActivity(intent)
        }
        btnSemestralRetornoHomeMembresia.setOnClickListener {
            intent=Intent(this, Membresia::class.java)
            startActivity(intent)
        }
        btnComprarSemestral.setOnClickListener {
            Toast.makeText(this,
                MENSAJE_COMPRA_PASE_SEMESTRAL, Toast.LENGTH_SHORT).show()
        }
    }
}