package com.example.sandbox.presentation.movie_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sandbox.FakeMovieDataFactory
import com.example.sandbox.domain.Movie

class MovieListViewModel : ViewModel() {

    private val factory = FakeMovieDataFactory()
    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>> = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        _movies.value = factory.getMovieList()
    }

}