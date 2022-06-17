package com.example.sandbox.data

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieDataSource {

    @GET("/3/movie/upcoming")
    suspend fun getMovies(@Query("api_key") key: String = apiKey): Response<MovieListResponse>
}