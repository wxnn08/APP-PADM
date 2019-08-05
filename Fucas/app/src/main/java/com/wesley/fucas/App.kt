package com.wesley.fucas

import android.app.Application
import android.content.Context

class App : Application() {
    companion object {
        val COMERCIO_POSITION: String = "COMERCIO_POSITION"
        lateinit var context: Context
            private set
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}