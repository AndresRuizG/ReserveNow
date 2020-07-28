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
        btn_homeusuario.setOnClickListener{
            var intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_addhorariousuario.setOnClickListener{
            var intent = Intent(this, UsuarioAgregarAgendaActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}