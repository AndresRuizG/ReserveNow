package com.projectmoviles.myapplication.User

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.projectmoviles.myapplication.LoginActivity
import com.projectmoviles.myapplication.R
import com.projectmoviles.myapplication.admin.AdminActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_usuario.*
//Provider type es para desiganr el metod de autenticacion
enum class ProviderType{
    GOOGLE,
    FACEBOOK
}

class UsuarioActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)
        btn_agendarusuario.setOnClickListener{
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_historialusuario.setOnClickListener{
            var intent = Intent(this, HistorialUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        btn_mebresiausuario.setOnClickListener{

            var intent = Intent(this, MembresiaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonConfig.setOnClickListener{

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

}