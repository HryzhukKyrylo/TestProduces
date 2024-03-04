package com.example.testproduces.di.component

import com.example.testproduces.MainActivity
import com.example.testproduces.di.module.AppModule
import com.example.testproduces.di.module.ExecutorModule
import dagger.producers.ProductionComponent

@ProductionComponent(modules = [AppModule::class, ExecutorModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}