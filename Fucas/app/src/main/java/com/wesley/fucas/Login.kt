package com.wesley.fucas
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.wesley.fucas.model.LoginDAO

class Login : AppCompatActivity() {

    private lateinit var usuario : TextInputEditText
    private lateinit var senha : TextInputEditText
    private lateinit var entrar : Button
    private lateinit var anonimo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        bindComponents()
        setEvents()

        //TODO: INCLUDE FACEBOOK LOGIN
        //https://developers.facebook.com/docs/facebook-login/android?locale=pt_BR#quickstarts-header
    }

    private fun setEvents() {
        entrar.setOnClickListener {

            // Login validation
            if(validaCadastro()) {
                var intent = Intent(this, Catalogo::class.java)
                intent.putExtra("LOGIN", true)
                startActivity(intent)
            } else {
                Snackbar.make(it, R.string.login_snack_erro, Snackbar.LENGTH_LONG).setAction("Limpar", View.OnClickListener {
                    // Cleaning password text
                    senha.setText("")

                    // Moving focus (cursor) to password text
                    senha.isFocusableInTouchMode = true
                    senha.requestFocus()
                }) .show()
            }

            // Closing keyboard when Enter button is pressed
            (it.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).
                hideSoftInputFromWindow(it.windowToken, 0)
        }

        // Anonymous login
        anonimo.setOnClickListener {
            var intent = Intent(this, Catalogo::class.java)
            intent.putExtra("LOGIN", false)
            startActivity(intent)
        }
    }

    private fun validaCadastro(): Boolean {
        return LoginDAO.instance.existeCadastro(usuario.text.toString(), senha.text.toString())
    }

    private fun bindComponents() {
        usuario = findViewById(R.id.login_edit_usuario_id)
        senha = findViewById(R.id.login_edit_senha_id)
        entrar = findViewById(R.id.login_button_entrar_id)
        anonimo = findViewById(R.id.login_button_anonimo_id)
    }
}
