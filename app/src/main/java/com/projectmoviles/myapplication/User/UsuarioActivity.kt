package com.projectmoviles.myapplication.User

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.projectmoviles.myapplication.LoginActivity
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_usuario.*


class UsuarioActivity : AppCompatActivity() {
    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        drawerLayout = findViewById(R.id.drawer_menu);
        navigationView = findViewById(R.id.nav_view);

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        toggle.syncState();
/*
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
        }*/
    }
}