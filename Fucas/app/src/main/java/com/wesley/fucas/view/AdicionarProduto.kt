package com.wesley.fucas.view

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Environment
import android.os.Message
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.wesley.fucas.R

import kotlinx.android.synthetic.main.activity_adicionar_produto.*
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class AdicionarProduto : AppCompatActivity() {


    lateinit var txtNome : EditText
    lateinit var txtDescricao : EditText
    lateinit var txtValor : EditText
    lateinit var btnCapturar : Button
    lateinit var arqFoto : File
    private val permissionLogic = PermissionsLogic()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adicionar_produto)
        setSupportActionBar(toolbar)

        bindComponents()
        permissionLogic.check()
        clickListeners()
   }

    private fun clickListeners() {
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        btnCapturar.setOnClickListener {

        }
    }

    private fun bindComponents() {
        txtNome = findViewById(R.id.adicionar_edt_nome)
        txtDescricao = findViewById(R.id.adicionar_edt_descricao)
        txtValor = findViewById(R.id.adicionar_edt_valor)
        btnCapturar = findViewById(R.id.adicionar_btn_capturar)
        btnCapturar.isEnabled = false
    }

    fun enableUI() {
        btnCapturar.isEnabled = true
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA), 0)
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

    @Throws(IOException::class)
    private fun createImageFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        return File(storageDir,"$timeStamp.jpeg").also {
            it.createNewFile()
        }
    }


    private inner class PermissionsLogic {
        private fun showRationaleDialog() {
            val self = this@AdicionarProduto
            val builder = AlertDialog.Builder(self)
            val dialog : AlertDialog

            builder.setMessage(R.string.camera_armazenamento_rationale)
            builder.setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
                requestPermission()
            }
            dialog = builder.create()
            dialog.show()
        }

        fun showPermissionDeniedResponseDialog(message: Int) {
            val self = this@AdicionarProduto
            val builder = AlertDialog.Builder(self)
            val dialog : AlertDialog

            builder.setMessage(message)
            builder.setPositiveButton("OK") { dialog, which ->
                dialog.cancel()
                self.finish()
            }
            dialog = builder.create()
            dialog.show()
        }

        private fun hasAllPermissions() :Boolean {
            return ContextCompat.checkSelfPermission(this@AdicionarProduto,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                    ContextCompat.checkSelfPermission(this@AdicionarProduto,
                        Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
        }

        private fun shouldShowAnyRationale() : Boolean {
            return ActivityCompat.shouldShowRequestPermissionRationale(this@AdicionarProduto,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) && ActivityCompat.shouldShowRequestPermissionRationale(this@AdicionarProduto,
                Manifest.permission.CAMERA)
        }

        fun check() {
            if(hasAllPermissions())
                enableUI()
            else {
                if(shouldShowAnyRationale())
                    showRationaleDialog()
                else
                    requestPermission()
            }
        }

    }

}


