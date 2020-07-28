package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrarse.*
import kotlinx.android.synthetic.main.activity_registrarse.btnInicio

class Registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        btnInicio.setOnClickListener {
            val intent=Intent(this, Login::class.java)
            startActivity(intent)
        }

        btnRegistrarDatos.setOnClickListener {
            var nombreUser = editTextPersonName.text.toString();
            var correo = editTextEmailAddress.getText().toString();
            var pass = editTextPassword.text.toString();
            var confirmepass= editTextPasswordConfirm.text.toString();

            if (!nombreUser.isEmpty() && !correo.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(correo).matches() &&
                !pass.isEmpty() && pass.length >= 8 && pass==confirmepass) {
                Toast.makeText(this, "Bienvenido", Toast.LENGTH_SHORT).show()
            }
            if (correo.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
                editTextEmailAddress.setError("Ingrese un correo electónico valido")
            }
            if (pass.isEmpty() || pass.length < 8) {
                editTextPassword.setError("Ingrese una contraseña que tenga almenos 8 caracteres")
            }
            if(confirmepass!=pass){
                editTextPasswordConfirm.setError("Las contraseñas no coinciden");
            }
        }

    }
}