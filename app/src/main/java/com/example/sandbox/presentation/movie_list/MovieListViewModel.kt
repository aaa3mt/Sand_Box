package com.example.sandbox.presentation.movie_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sandbox.presentation.MovieUi
import com.example.sandbox.domain.MovieRepository
import com.example.sandbox.domain.Response
import com.example.sandbox.presentation.MovieToMovieUiMapper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

class MovieListViewModel(
    private val repository: MovieRepository,
    private val movieToMovieUiMapper: MovieToMovieUiMapper,
    private val ioContext: CoroutineContext = Dispatchers.IO
) : ViewModel() {

    private val _movies = MutableLiveData<List<MovieUi>>()

    val movies: LiveData<List<MovieUi>> = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies() = viewModelScope.launch {
        withContext(ioContext) {
            when (val result = repository.getMovies()) {
                is Response.Success -> _movies.postValue(
                    result.data.map { movieToMovieUiMapper.map(it) }
                )
                is Response.Failure -> TODO()
            }
        }
    }

}