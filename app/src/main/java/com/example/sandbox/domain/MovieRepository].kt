package com.example.sandbox.domain

interface MovieRepository {

    suspend fun getMovies(): List<Movie>
}