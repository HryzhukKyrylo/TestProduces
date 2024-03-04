package com.example.testproduces

import android.app.Application
import android.util.Log

class Application : Application() {
    override fun onCreate() {
        super.onCreate()
        Log.d("testtest", "Application.onCreate: ${System.currentTimeMillis()}")
    }
}