package com.example.testproduces.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.common.util.concurrent.Futures
import com.google.common.util.concurrent.ListenableFuture
import dagger.Binds
import dagger.producers.ProducerModule
import dagger.producers.Produces
import dagger.producers.Production

@ProducerModule
class AppModule {

//    @Produces
//    fun produceStr(): ListenableFuture<String> {
//        return Futures.immediateFuture("test_str")
//    }
    @Produces
    fun produceStr(): String {
        return "test_str"
    }
}