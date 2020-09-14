package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projectmoviles.myapplication.MENSAJE_COMPRA_PASE_MENSUAL
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_mensual.*

class MembresiaMensualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_mensual)
        btnDerechaMensual.setOnClickListener {
            intent = Intent(this, MembresiaSemestralActivity::class.java)
            startActivity(intent)
        }
        btnIzquierdaMensual.setOnClickListener {
            intent = Intent(this, MembresiaDiariaActivity::class.java)
            startActivity(intent)
        }
        btnMensualRetornoHomeMembresia.setOnClickListener {
            intent = Intent(this, MembresiaUsuarioActivity::class.java)
            startActivity(intent)
        }
        btnComprarMensual.setOnClickListener {
            Toast.makeText(this,
                MENSAJE_COMPRA_PASE_MENSUAL, Toast.LENGTH_SHORT).show()
        }
    }
}