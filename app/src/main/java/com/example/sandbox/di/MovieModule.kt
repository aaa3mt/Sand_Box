package com.example.sandbox.di

import com.example.sandbox.data.DefaultMovieRepository
import com.example.sandbox.data.MovieApi
import com.example.sandbox.domain.MovieRepository
import com.example.sandbox.presentation.movie_list.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val movieModule = module {

    single { get<Retrofit>().create(MovieApi::class.java) }
    factory { DefaultMovieRepository(movieApi = get()) }.bind(MovieRepository::class)
    viewModel { MovieListViewModel(repository = get()) }


}