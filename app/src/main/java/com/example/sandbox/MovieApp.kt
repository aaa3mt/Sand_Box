package com.example.sandbox

import android.app.Application
import com.example.sandbox.di.movieModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MovieApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MovieApp)
            modules(movieModule)
        }
    }
}