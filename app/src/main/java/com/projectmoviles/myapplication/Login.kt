package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnRegistrar.setOnClickListener {
            val intent= Intent(this,Registrarse::class.java)
            startActivity(intent)
        }
        btnInicio.setOnClickListener {
            var correo = editTextEmailAddress.getText().toString();
            var pass = editTextPassword.text.toString();
            if (!correo.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(correo).matches() &&
                !pass.isEmpty() && pass.length >= 8
            ) {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
            }
            if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                editTextEmailAddress.setError("Ingrese un correo electónico valido")
            }
            if (pass.isEmpty() || pass.length < 8) {
                editTextPassword.setError("Ingrese una contraseña que tenga almenos 8 caracteres")
            }


            /*llamar a la actividad home*/
            if (editTextEmailAddress.equals("jorgequilumba@epn.edu.ec") and editTextPassword.equals("12345678")) {
                //var intent = Intent(this, PrincipalTmpActivity::class.java)  //llamar a la actividad principal

                startActivity(intent)

                //Toast.makeText(this, "Bienvenido", Toast.LENGTH_LONG).show()
            }
        }
    }

}