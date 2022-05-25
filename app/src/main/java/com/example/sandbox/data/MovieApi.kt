package com.example.sandbox.data

import com.example.sandbox.domain.Movie
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    @GET("/3/movie/upcoming")
    suspend fun getMovies(@Query("api_key") key: String = apiKey): Response<Movie>
}