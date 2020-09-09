package com.projectmoviles.myapplication

import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.projectmoviles.myapplication.User.ProviderType
import com.projectmoviles.myapplication.User.UsuarioActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_registrarse.*

class RegistraseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Message", "Integracion de firebase completa")
        analytics.logEvent("InitScreen", bundle)
        registrarUser()
    }

    fun registrarUser(){
        title ="Registar usuario"
        btnRegistrarDatos.setOnClickListener {
            NOMBRRE_USUARIO = editTextPersonName.text.toString();
            CORREO = editTextEmailAddress.getText().toString();
            CONTRASENIA = editTextPassword.text.toString();
            CONFIRMAR_CONTRASENIA= editTextPasswordConfirm.text.toString();

            if (NOMBRRE_USUARIO.isNotEmpty() && !CORREO.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(CORREO).matches() &&
                !CONTRASENIA.isNotEmpty() && CONTRASENIA.length >= 8 && CONTRASENIA==CONFIRMAR_CONTRASENIA) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(CORREO, CONTRASENIA).addOnCompleteListener{
                    if(it.isSuccessful){
                        showHomeUsuario(it.result?.user?.email ?: "", ProviderType.BASIC)
                        Toast.makeText(this, MENSAJE_USUARIO_CREADO, Toast.LENGTH_SHORT).show()
                    }else{
                        showAlert()
                    }
                }
                Toast.makeText(this, MENSAJE_BIENVEINDA, Toast.LENGTH_SHORT).show()
            }
            if (CORREO.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(CORREO).matches()) {
                editTextEmailAddress.setError(MENSAJE_ERROR_CORREO)
            }
            if (CONTRASENIA.isEmpty() || CONTRASENIA.length < 8) {
                editTextPassword.setError(MENSAJE_ERROR_CONTRASENIA)
            }
            if(CONFIRMAR_CONTRASENIA!=CONTRASENIA){
                editTextPasswordConfirm.setError(MENSAJE_ERROR_CONTRASENIAS_IGUALES);
            }
        }
    }
    fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Error en la autenticacion de usuario")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
    fun showHomeUsuario(correo: String, contrasenia: ProviderType ){
        val homeIntent = Intent(this, UsuarioActivity::class.java).apply {
            putExtra("correo", correo)
            putExtra("contrasenia", contrasenia.name)
        }
        startActivity(homeIntent)
    }
}