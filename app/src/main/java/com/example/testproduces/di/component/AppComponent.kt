package com.example.testproduces.di.component

import android.content.SharedPreferences
import com.example.testproduces.di.module.AppModule
import com.example.testproduces.di.module.ExecutorModule
import com.google.common.util.concurrent.ListenableFuture
import dagger.producers.ProductionComponent

@ProductionComponent(modules = [AppModule::class, ExecutorModule::class])
interface AppComponent {

    val sp: ListenableFuture<SharedPreferences>

    val testStr: ListenableFuture<String>
}