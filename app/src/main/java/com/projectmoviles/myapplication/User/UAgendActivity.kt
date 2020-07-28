package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.R
import com.projectmoviles.myapplication.user.UAgenAgregarActivity
import kotlinx.android.synthetic.main.activity_u_agend.*
import kotlinx.android.synthetic.main.activity_u_agend.btn_homeusuario
import kotlinx.android.synthetic.main.activity_u_historial3.*

class UAgendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_u_agend)
        btn_homeusuario.setOnClickListener{
            var intent = Intent(this, UsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_addhorariousuario.setOnClickListener{
            var intent = Intent(this, UAgenAgregarActivity::class.java)
            startActivity(intent)
            finish()
        }

    }
}