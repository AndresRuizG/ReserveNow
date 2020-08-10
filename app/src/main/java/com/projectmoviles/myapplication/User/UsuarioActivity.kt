package com.projectmoviles.myapplication.User

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.projectmoviles.myapplication.R
import kotlinx.android.synthetic.main.activity_usuario.*


class UsuarioActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var drawerLayout: DrawerLayout? = null
    var navigationView: NavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_usuario)

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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        /*switch (menuItem.getItemId()){
            case R.id.nav_perfil:
            TODO

            case R.id.nav_salir:
            TODO
        }*/
        return true;
    }


}