package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_usuario_agregar_agenda.*

class UsuarioAgregarAgendaActivity : AppCompatActivity() {
    val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_usuario_agregar_agenda)
        btn_checkhorario.setOnClickListener {
            Toast.makeText(
                getApplicationContext(),
                "Horario Registrado", Toast.LENGTH_SHORT
            ).show()
            intentAgendar()

        }
        btn_cancelhorario.setOnClickListener {
            Toast.makeText(
                getApplicationContext(),
                "Horario no registrado", Toast.LENGTH_SHORT
            ).show()
            intentAgendar()

        }
        btn_atrasagendausuario.setOnClickListener {
           intentAgendar()
        }
    }
    fun intentAgendar(){
        var intent = Intent(this, AgendaUsuarioActivity::class.java)
        intent.putExtra("USER_EMAIL", email)

        startActivity(intent)
        finish()
    }
}