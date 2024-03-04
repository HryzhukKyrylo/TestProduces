package com.example.testproduces.di.module

import dagger.Module
import dagger.Provides
import dagger.producers.Production
import java.util.concurrent.Executor
import java.util.concurrent.Executors

@Module
class ExecutorModule {
    @Provides
    @Production
    fun executor(): Executor = Executors.newCachedThreadPool()
}