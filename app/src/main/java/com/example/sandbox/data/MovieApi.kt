package com.example.sandbox.data

import com.example.sandbox.domain.Movie
import retrofit2.http.GET

interface MovieApi {
    @GET("c6440e374a610a5f23d398751c4040b2")
    suspend fun getApi(): Movie
}