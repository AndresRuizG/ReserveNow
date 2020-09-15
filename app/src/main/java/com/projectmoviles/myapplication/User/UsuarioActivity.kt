package com.projectmoviles.myapplication.User

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.projectmoviles.myapplication.R
import com.projectmoviles.myapplication.admin.AdminActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_usuario.*
//Provider type es para desiganr el metod de autenticacion
enum class ProviderType{
    GOOGLE,
    FACEBOOK
}


class UsuarioActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

        var relativeLayoutAgendar: RelativeLayout = findViewById(R.id.RelativeLayoutAgendar)
        relativeLayoutAgendar.setOnClickListener{
            Toast.makeText(
                getApplicationContext(),
                "Agendar", Toast.LENGTH_SHORT
            ).show()
            var intent = Intent(this, AgendaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        var relativeLayoutMembresia: RelativeLayout = findViewById(R.id.RelativeLayoutMembresia)
        relativeLayoutMembresia.setOnClickListener{
            Toast.makeText(
                getApplicationContext(),
                "Membresia", Toast.LENGTH_SHORT
            ).show()
            var intent = Intent(this, MembresiaUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }
        var relativeLayoutHistorial: RelativeLayout = findViewById(R.id.RelativeLayoutHistorial)
        relativeLayoutHistorial.setOnClickListener{
            Toast.makeText(
                getApplicationContext(),
                "Historial", Toast.LENGTH_SHORT
            ).show()
            var intent = Intent(this, HistorialUsuarioActivity::class.java)
            startActivity(intent)
            finish()
        }

        drawerLayout = findViewById(R.id.drawer_menu)
        navigationView = findViewById(R.id.nav_view)

        navigationView?.bringToFront()
        val toggle =
            ActionBarDrawerToggle(
                this,
                drawerLayout,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close
            )
        toggle.syncState()

        navigationView?.setNavigationItemSelectedListener(this);

    }

    override fun onBackPressed() {
        if(drawerLayout!!.isDrawerOpen(GravityCompat.START)){
            drawerLayout?.closeDrawer(GravityCompat.START)
        }else{
            super.onBackPressed();
        }
    }

}