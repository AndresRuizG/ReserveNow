package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_agenda_usuario.*


class AgendaUsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agenda_usuario)
        val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd

        btn_homeusuario.setOnClickListener{
            var intent = Intent(this, UsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()
        }
        btn_addhorariousuario.setOnClickListener{
            var intent = Intent(this, UsuarioAgregarAgendaActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()
        }

    }
}