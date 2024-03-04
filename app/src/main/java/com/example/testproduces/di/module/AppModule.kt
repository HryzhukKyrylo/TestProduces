package com.example.testproduces.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.producers.ProducerModule
import dagger.producers.Produces

@Module
class AppModule(private val application: Application) {

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        val sp = application.getSharedPreferences("test_shared_preferences", Context.MODE_PRIVATE)
        return sp
    }

    @Provides
    fun provideStr(sp: SharedPreferences): String {
        val str = sp.getString("edit_text", "") ?: ""
        return str
    }
}