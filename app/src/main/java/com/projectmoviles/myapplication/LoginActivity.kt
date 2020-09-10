package com.projectmoviles.myapplication

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.projectmoviles.myapplication.User.ProviderType
import com.projectmoviles.myapplication.User.UsuarioActivity
import com.projectmoviles.myapplication.admin.AdminActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    private  val GOOGLE_SING_IN = 100
    private val callbackmanager = CallbackManager.Factory.create()
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance();
        /*btnInicio.setOnClickListener {
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
        }*/
        val analytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("Message", "Integracion de firebase completa")
        analytics.logEvent("InitScreen", bundle)
        inicioSesion()
        //inicioSesionGoogle()

    }
   /* private fun inicioSesionGoogle(){
        val prefs =getSharedPreferences(getString(R.string.prefs_file), Context.MODE_PRIVATE)
        val correo = prefs.getString("correo", null)
        val provider = prefs.getString("provider", null)
        if(correo !=null && provider !=null){
            showHomeUsuario(correo, ProviderType.valueOf(provider))
        }

    }*/
    fun inicioSesion(){
        title ="Autenticacion"
        btnInicio.setOnClickListener {
            CORREO= editTextEmailAddress.getText().toString();
            CONTRASENIA = editTextPassword.text.toString();
            if (!CORREO.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(CORREO).matches() &&
                !CONTRASENIA.isEmpty() && CONTRASENIA.length >= 8) {
                auth.signInWithEmailAndPassword(CORREO, CONTRASENIA).addOnCompleteListener{
                    if(it.isSuccessful){
                        showHomeUsuario()
                        Toast.makeText(this, MENSAJE_BIENVEINDA, Toast.LENGTH_SHORT).show()
                    }else{
                        showAlert()
                    }
                }
            }
            if (CORREO.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(CORREO).matches()) {
                editTextEmailAddress.setError(MENSAJE_ERROR_CORREO)
            }
            if (CONTRASENIA.isEmpty() || CONTRASENIA.length < 8) {
                editTextPassword.setError(MENSAJE_ERROR_CONTRASENIA)
            }
        }
        btnRegistrar.setOnClickListener {
            var registrarIntent = Intent(this, RegistraseActivity::class.java)
            startActivity(registrarIntent)
        }
        btnGoogle.setOnClickListener {
            val googleConf = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build()
            val googleClient = GoogleSignIn.getClient(this, googleConf)
            googleClient.signOut()
            startActivityForResult(googleClient.signInIntent, GOOGLE_SING_IN)
        }
       btnFacebook.setOnClickListener {
           LoginManager.getInstance().logInWithReadPermissions(this, listOf("email"))
           LoginManager.getInstance().registerCallback(callbackmanager,
           object : FacebookCallback<LoginResult>{
               override fun onSuccess(result: LoginResult?) {
                    result?.let {
                        val token = it.accessToken
                        val credential = FacebookAuthProvider.getCredential(token.token)
                            auth.signInWithCredential(credential).addOnCompleteListener {
                                if(it.isSuccessful){
                                    //showHomeUsuario(it.result?.user?.email ?: "", ProviderType.FACEBOOK)
                                    showHomeUsuario()
                                }else{
                                    showAlert()
                                }
                            }
                    }
               }
               override fun onCancel() {

               }
               override fun onError(error: FacebookException?) {
                   showAlert()
               }
           })
       }

    }


    fun showAlert(){
        val builder = AlertDialog.Builder(this)
        builder.setIcon(R.drawable.ic_error)
        builder.setTitle("Error")
        builder.setMessage("El usuario no se encuentra registrado")
        builder.setPositiveButton("Aceptar", null)
        val dialog:AlertDialog = builder.create()
        dialog.show()
    }
    fun showHomeUsuario(){
        val homeIntent = Intent(this, UsuarioActivity::class.java)
        startActivity(homeIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackmanager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode==GOOGLE_SING_IN){
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)
                if(account!= null){
                    val credential = GoogleAuthProvider.getCredential(account.idToken,null)
                    auth.signInWithCredential(credential).addOnCompleteListener {
                        if(it.isSuccessful){
                            showHomeUsuario()
                            Toast.makeText(this, MENSAJE_BIENVEINDA, Toast.LENGTH_SHORT).show()
                        }else{
                            showAlert()
                        }
                    }
                }
            } catch (e: ApiException){
                showAlert()
            }

        }
    }

}