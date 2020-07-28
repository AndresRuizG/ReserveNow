package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projectmoviles.myapplication.MENSAJE_COMPRA_PASE_DIARIO
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_diaria.*

class Membresia_diaria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_diaria)
        btnDerechaDiario.setOnClickListener {
            intent = Intent(this, Membresia_mensual::class.java)
            startActivity(intent)
        }

        btnHomeMembresia.setOnClickListener {
            intent = Intent(this, Membresia::class.java)
            startActivity(intent)
        }
        btnComprarDiario.setOnClickListener {
            Toast.makeText(this,
                MENSAJE_COMPRA_PASE_DIARIO, Toast.LENGTH_SHORT).show()
        }
    }
}