package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_usuario_agregar_agenda.*

class UsuarioAgregarAgendaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_usuario_agregar_agenda)
        btn_checkhorario.setOnClickListener {
            Toast.makeText(
                getApplicationContext(),
                "Horario Registrado", Toast.LENGTH_SHORT
            ).show()
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_cancelhorario.setOnClickListener {
            Toast.makeText(
                getApplicationContext(),
                "Horario no registrado", Toast.LENGTH_SHORT
            ).show()
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_atrasagendausuario.setOnClickListener {
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}