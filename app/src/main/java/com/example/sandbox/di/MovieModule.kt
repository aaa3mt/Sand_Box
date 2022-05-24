package com.example.sandbox.di

import com.example.sandbox.presentation.movie_list.MovieListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val movieModule = module {

    viewModel { MovieListViewModel() }

}