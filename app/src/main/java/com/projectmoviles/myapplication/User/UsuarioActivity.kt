package com.projectmoviles.myapplication.User

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.projectmoviles.myapplication.LoginActivity
import com.projectmoviles.myapplication.MENSAJE_BIENVEINDA
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
        val email = intent.getStringExtra("USER_EMAIL") //variable unica para cada usuario con esta hacemos las consultas a la bdd


        btn_agendarusuario.setOnClickListener{
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()

        }
        btn_historialusuario.setOnClickListener{
            var intent = Intent(this, HistorialUsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)
            startActivity(intent)
            finish()
        }
        btn_mebresiausuario.setOnClickListener{

            var intent = Intent(this, MembresiaUsuarioActivity::class.java)
            intent.putExtra("USER_EMAIL",email)

            startActivity(intent)
            finish()
        }
        buttonConfig.setOnClickListener{

            var intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun onNavigationItemSelected(item: MenuItem): Boolean {
        /*switch (menuItem.getItemId()){
            case R.id.nav_perfil:
            TODO

            case R.id.nav_salir:
            TODO
        }*/
        return true;
    }



}