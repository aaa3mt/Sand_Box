package com.example.sandbox.presentation.movie_list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sandbox.FakeMovieDataFactory
import com.example.sandbox.domain.Movie
import com.example.sandbox.domain.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MovieListViewModel(
    private val repository: MovieRepository,
    private val ioContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private val factory = FakeMovieDataFactory()
    private val _movies = MutableLiveData<List<Movie>>()

    val movies: LiveData<List<Movie>> = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies() = viewModelScope.launch{
        withContext(ioContext) {
            repository.getMovies()
        }
    }

}