package com.example.sandbox.data

import com.example.sandbox.domain.Movie
import com.example.sandbox.domain.MovieRepository

class DefaultMovieRepository(private val movieApi: MovieApi) : MovieRepository {

    override suspend fun getMovies(): List<Movie> {

        val result = movieApi.getMovies()
        return emptyList()
    }
}