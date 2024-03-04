package com.example.testproduces.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.producers.ProducerModule
import dagger.producers.Produces

@ProducerModule
class AppModule(private val application: Application) {

    @Produces
    fun produceSharedPreferences(): SharedPreferences {
        val sp = application.getSharedPreferences("test_shared_preferences", Context.MODE_PRIVATE)
        return sp
    }

    @Produces
    fun produceStr(sp: SharedPreferences): String {
        val str = sp.getString("edit_text", "") ?: ""
        return str
    }
}