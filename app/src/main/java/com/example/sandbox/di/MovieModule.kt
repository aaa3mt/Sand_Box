package com.example.sandbox.di

import com.example.sandbox.BuildConfig
import com.example.sandbox.data.MovieApi
import com.example.sandbox.presentation.movie_list.MovieListViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val movieModule = module {

    viewModel { MovieListViewModel() }

    single { provideInterceptor() }
    factory { provideHttpClient(get()) }
    factory { provideMovieApi(get()) }
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

fun provideMovieApi(retrofit: Retrofit): MovieApi = retrofit.create(MovieApi::class.java)

fun provideInterceptor(): Interceptor {
    return object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val builder = chain.request().newBuilder()

            return chain.proceed(builder.build())
        }
    }
}