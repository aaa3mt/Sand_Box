package com.example.sandbox.data


data class MovieListResponse(
    val results: List<MovieResponse>
)
data class MovieResponse(
    val id: Int,
    val overview: String,
    val poster_path: String,
    val release_date: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)