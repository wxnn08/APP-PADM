package com.wesley.fucas.view
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.wesley.fucas.App
import com.wesley.fucas.R
import com.wesley.fucas.viewmodel.LoginViewModel

class Login : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var usuario : TextInputEditText
    private lateinit var senha : TextInputEditText
    private lateinit var entrar : Button
    private lateinit var anonimo : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        bindComponents()
        setEvents()

        //TODO: INCLUIR LOGIN COM O FACEBOOK
        //https://developers.facebook.com/docs/facebook-login/android?locale=pt_BR#quickstarts-header
    }

    override fun onStart() {
        super.onStart()

        // Recupera usuario e senha digitados
        usuario.setText(loginViewModel.usuario)
        senha.setText(loginViewModel.senha)
    }

    override fun onStop() {
        super.onStop()
        // Salva usuario senha digitados
        loginViewModel.usuario = usuario.text.toString()
        loginViewModel.senha = senha.text.toString()
    }

    private fun bindComponents() {
        usuario = findViewById(R.id.login_edit_usuario_id)
        senha = findViewById(R.id.login_edit_senha_id)
        entrar = findViewById(R.id.login_button_entrar_id)
        anonimo = findViewById(R.id.login_button_anonimo_id)
    }

    private fun setEvents() {
        entrar.setOnClickListener {

            // Validação de login
            // Retorna id se o cadastro existir e -1 caso contrário
            val idLogin = idCadastro()
            if(idLogin != -1) {
                val intent = Intent(this, Catalogo::class.java)
                intent.putExtra(App.LOGIN_EXTRA_ACTIVITY, idLogin)
                startActivity(intent)

            } else createSnack(R.string.usuario_senha_incorretos)

            // Fechar teclado quando o enter for pressionado
            (it.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager).
                hideSoftInputFromWindow(it.windowToken, 0)
        }

        // Login anonimo
        anonimo.setOnClickListener {
            val intent = Intent(this, Catalogo::class.java)
            intent.putExtra(App.LOGIN_EXTRA_ACTIVITY, App.LOGIN_ID_ANONIMO)
            startActivity(intent)
        }
    }

    private fun idCadastro(): Int {
        return loginViewModel.idCadastro(usuario.text.toString(), senha.text.toString())
    }


    private fun createSnack(mensagem: Int) {
        Snackbar.make(
            findViewById(R.id.login_layout),
            mensagem,
            Snackbar.LENGTH_LONG
        ).show()
    }
}
