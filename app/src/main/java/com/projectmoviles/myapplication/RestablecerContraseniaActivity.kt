package com.projectmoviles.myapplication

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_restablecer_contrasenia.*

class RestablecerContraseniaActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restablecer_contrasenia)
        auth = FirebaseAuth.getInstance();
        btnEnviarCorreo.setOnClickListener {
            CORREO= emailEditText.getText().toString();

            if (CORREO.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(CORREO).matches()) {
                editTextEmailAddress.setError(MENSAJE_ERROR_CORREO)
            }else{
            enviarCorreo(CORREO)
            emailEditText.setText("")
            irALogin()
            }
        }

    }

    fun enviarCorreo(correo:String){
        auth.sendPasswordResetEmail(correo)
            .addOnCompleteListener {
                if(it.isSuccessful){
                    Toast.makeText(this,CORREO_ENVIADO, Toast.LENGTH_SHORT).show()
                    irALogin()
                }
                else{
                    showAlert()
                }
            }
    }
    fun irALogin(){
        var loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }
    fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.ic_error)
        builder.setTitle("Error")
        builder.setMessage(ERROR_ENVIAR_CORREO)
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}