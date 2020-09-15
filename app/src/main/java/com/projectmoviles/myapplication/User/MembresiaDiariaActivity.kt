package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_membresia_diaria.*
import kotlinx.android.synthetic.main.activity_membresia_usuario.*
import java.text.SimpleDateFormat
import java.util.*

class MembresiaDiariaActivity : AppCompatActivity() {
    val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_membresia_diaria)
        btnDerechaDiario.setOnClickListener {
            intent = Intent(this, MembresiaMensualActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()
        }
        btnHomeMembresia.setOnClickListener {
            val intent= Intent(this, UsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
        }
        btnComprarDiario.setOnClickListener {
            intent = Intent(this, MembresiaUsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)
            startActivity(intent)
            finish()
            editTextTipoMembresia.setText("Diaria");
            //deberia existir una variable para aumentar los dias o reducirlos.
            editTextDiasVigentes.setText("1 Dia");
            val sdf = SimpleDateFormat("dd/M/yyyy hh:mm:ss")
            val currentDate = sdf.format(Date())
            //variables

            editTextFechaVencimiento.setText(currentDate);
        }
    }
}