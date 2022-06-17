package com.example.sandbox.data

import com.google.gson.annotations.SerializedName

data class MovieListResponse(
    val results: List<MovieResponse>
)
data class MovieResponse(
    val id: Int,
    val overview: String,
    @SerializedName("poster_path")
    val posterPath: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)