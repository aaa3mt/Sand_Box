package com.example.sandbox.data

import com.example.sandbox.domain.Mapper
import com.example.sandbox.domain.Movie

class MovieResponseApiMapper: Mapper<MovieResponse, Movie>() {

    override fun map(from: MovieResponse): Movie {
        return Movie(
            rating = from.voteAverage,
            title = from.title,
            description = from.overview,
            imageUrl = imageUrl + from.posterPath
        )
    }
}