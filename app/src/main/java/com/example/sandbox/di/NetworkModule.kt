package com.example.sandbox.di

import com.example.sandbox.data.Base_url
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val client = OkHttpClient.Builder().build()

val networkModule = module {
    single { provideRetrofit() }
}

fun provideRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(Base_url)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()
}
