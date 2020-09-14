package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projectmoviles.myapplication.MENSAJE_COMPRA_PASE_ANUAL
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_anual.*
import kotlinx.android.synthetic.main.activity_membresia_mensual.*

class MembresiaAnualActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_anual)


        btnIzquierdaMensual.setOnClickListener {
            intent = Intent(this, MembresiaSemestralActivity::class.java)
            startActivity(intent)
        }
        btnAnualRetornoHomeMembresia.setOnClickListener {
            intent = Intent(this, MembresiaUsuarioActivity::class.java)
            startActivity(intent)
        }
        btnComprarAnual.setOnClickListener {
            Toast.makeText(this,
                MENSAJE_COMPRA_PASE_ANUAL, Toast.LENGTH_SHORT).show()
        }
    }
}