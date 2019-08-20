package com.wesley.fucas

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        const val LOGIN_ID_ANONIMO: Int = -1
        const val LOGIN_EXTRA_ACTIVITY = "loginExtraActivity"
        const val COMERCIO_POSITION: String = "comercioPosition"
        const val PRODUTO_POSITION: String = "produtoPosition"

        lateinit var context: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}