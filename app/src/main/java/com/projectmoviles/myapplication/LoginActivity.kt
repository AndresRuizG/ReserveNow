package com.projectmoviles.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.projectmoviles.myapplication.User.UsuarioActivity
import com.projectmoviles.myapplication.admin.AdminActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnRegistrar.setOnClickListener {
            val intent= Intent(this,RegistraseActivity::class.java)
            startActivity(intent)
        }
        btnInicio.setOnClickListener {
            /*
            CORREO= editTextEmailAddress.getText().toString();
            CONTRASENIA = editTextPassword.text.toString();
            if (!CORREO.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(CORREO).matches() &&
                !CONTRASENIA.isEmpty() && CONTRASENIA.length >= 8
            ) {
                Toast.makeText(this, MENSAJE_BIENVEINDA, Toast.LENGTH_SHORT).show()
            }
            if (CORREO.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(CORREO).matches()) {
                editTextEmailAddress.setError(MENSAJE_ERROR_CORREO)
            }
            if (CONTRASENIA.isEmpty() || CONTRASENIA.length < 8) {
                editTextPassword.setError(MENSAJE_ERROR_CONTRASENIA)
            }

    i
*/
            if(editTextEmailAddress.text.toString().equals("jorge") and editTextPassword.text.toString().equals("12345678")){
                var intent = Intent(this, UsuarioActivity::class.java)
                startActivity(intent)
                finish()
            }else if(editTextEmailAddress.text.toString().equals("luis") and editTextPassword.text.toString().equals("12345678")){
                var intent = Intent(this, AdminActivity::class.java)
                startActivity(intent)
                finish()
            }

            finish()
            /*llamar a la actividad home
            if (editTextEmailAddress.equals("jorge.quilumba@epn.edu.ec") and editTextPassword.equals("12345678")) {
                var intent = Intent(this, UsuarioActivity::class.java)

                startActivity(intent)
                finish()


            }
            if (editTextEmailAddress.equals("andres.ruiz@epn.edu.ec") and editTextPassword.equals("12345678")) {
                var intent = Intent(this, UsuarioActivity::class.java)

                startActivity(intent)
                finish()


            }
            */
        }
    }
}