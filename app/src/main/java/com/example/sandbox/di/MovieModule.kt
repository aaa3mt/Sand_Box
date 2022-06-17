package com.example.sandbox.di

import com.example.sandbox.data.DefaultMovieRepository
import com.example.sandbox.data.MovieDataSource
import com.example.sandbox.data.MovieResponseApiMapper
import com.example.sandbox.domain.MovieRepository
import com.example.sandbox.presentation.MovieToMovieUiMapper
import com.example.sandbox.presentation.movie_list.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import retrofit2.Retrofit

val movieModule = module {

    single { get<Retrofit>().create(MovieDataSource::class.java) }
    factory {
        DefaultMovieRepository(
            movieDataSource = get(),
            movieResponseApiMapper = MovieResponseApiMapper()
        )
    }.bind(MovieRepository::class)
    viewModel {
        MovieListViewModel(
            repository = get(),
            movieToMovieUiMapper = MovieToMovieUiMapper()
        )
    }
}