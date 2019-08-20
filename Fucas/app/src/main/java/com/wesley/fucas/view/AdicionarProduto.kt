package com.wesley.fucas.view

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import com.wesley.fucas.App
import com.wesley.fucas.R
import com.wesley.fucas.model.Produto
import com.wesley.fucas.viewmodel.AdicionarProdutoViewModel
import kotlinx.android.synthetic.main.activity_adicionar_produto.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*
import com.wesley.fucas.R.color.black as black1

class AdicionarProduto : AppCompatActivity() {


    private lateinit var txtNome : EditText
    private lateinit var txtDescricao : EditText
    private lateinit var txtValor : EditText
    private lateinit var imgImagem : ImageView
    private lateinit var btnCapturar : Button
    private lateinit var adicionarProdutoViewModel : AdicionarProdutoViewModel
    private var uriFoto: Uri = Uri.EMPTY
    private var idComercio : Int = -1
    private val permissionLogic = PermissionsLogic(this)
    private val GALLERY = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_produto)
        setSupportActionBar(toolbar)

        adicionarProdutoViewModel = ViewModelProviders.of(this).get(AdicionarProdutoViewModel::class.java)
        idComercio = intent.getIntExtra(App.COMERCIO_POSITION, -1)

        bindComponents()
        permissionLogic.check()
        clickListeners()
   }

    private fun clickListeners() {
        fab.setOnClickListener { view ->
            val produto = criaProduto()
            adicionarProdutoViewModel.addProduto(idComercio, produto)
            finish()
        }

        btnCapturar.setOnClickListener { enviarIntentGaleria() }
    }

    private fun criaProduto(): Produto {
        return Produto(
            txtNome.text.toString(),
            txtDescricao.text.toString(),
            txtValor.text.toString().toDouble()
        ).also {
            it.uriFoto = uriFoto
            it.setCheck(true)
        }
    }

    private fun enviarIntentGaleria() {
        Intent(Intent.ACTION_PICK).apply {
            type = "image/*"
            startActivityForResult(this, GALLERY)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == GALLERY) {
            when(resultCode) {
                Activity.RESULT_OK -> {
                    val uri : Uri? = data?.data
                    Picasso.get().load(uri).into(imgImagem)
                    uriFoto = uri!!
                }
            }
        }
    }

    private fun bindComponents() {
        txtNome = findViewById(R.id.adicionar_edt_nome)
        txtDescricao = findViewById(R.id.adicionar_edt_descricao)
        txtValor = findViewById(R.id.adicionar_edt_valor)
        imgImagem = findViewById(R.id.adicionar_img_imagem)
        btnCapturar = findViewById(R.id.adicionar_btn_capturar)
        btnCapturar.isEnabled = false
    }


    fun enableUI() {
        btnCapturar.isEnabled = true
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if(requestCode == 0) {
            if(grantResults.size > 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED &&
                    grantResults[1] == PackageManager.PERMISSION_GRANTED)
                enableUI()
            else {
                permissionLogic.showPermissionDeniedResponseDialog(R.string.camera_armazenamento_nao_aceito)
            }
        }
    }

    private fun createSnack(mensagem: Int) {
        Snackbar.make(
            findViewById(R.id.adicionar_layout),
            mensagem,
            Snackbar.LENGTH_LONG
        ).show()
    }
}


