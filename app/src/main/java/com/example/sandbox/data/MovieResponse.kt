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
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
    @SerializedName("vote_count")
    val voteCount: Int
)