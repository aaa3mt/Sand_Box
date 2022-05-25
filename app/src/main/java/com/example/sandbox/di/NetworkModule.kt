package com.example.sandbox.di

import com.example.sandbox.BuildConfig
import com.example.sandbox.data.MovieApi
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { provideInterceptor() }
    factory { provideHttpClient(get()) }
    single { provideRetrofit(get()) }

}

fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create()).build()
}

fun provideHttpClient(okBuilder: OkHttpClient.Builder): OkHttpClient {
    return okBuilder.build()
}

fun provideInterceptor(): Interceptor {
    return object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder = chain.request().newBuilder()

            return chain.proceed(builder.build())
        }
    }
}
