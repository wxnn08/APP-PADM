package com.wesley.fucas.view

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.wesley.fucas.R

class PermissionsLogic(val activity: AppCompatActivity) {
    private fun showRationaleDialog() {
        val self = activity
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
        val self = activity
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
        return ContextCompat.checkSelfPermission(activity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
                ContextCompat.checkSelfPermission(activity,
                    Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

    private fun shouldShowAnyRationale() : Boolean {
        return ActivityCompat.shouldShowRequestPermissionRationale(activity,
            Manifest.permission.WRITE_EXTERNAL_STORAGE) && ActivityCompat.shouldShowRequestPermissionRationale(activity,
            Manifest.permission.CAMERA)
    }

    fun check() : Boolean {
        if(hasAllPermissions())
            return true
        else {
            if(shouldShowAnyRationale())
                showRationaleDialog()
            else
                requestPermission()
        }
        return false
    }

    fun requestPermission() {
        ActivityCompat.requestPermissions(activity,
            arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.CAMERA), 0)
    }


}
