package com.example.sandbox

import android.app.Application
import com.example.sandbox.di.movieModule
import com.example.sandbox.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApp)
            modules(networkModule, movieModule)
        }
    }
}