package com.example.sandbox.data

import com.example.sandbox.di.Mapper
import com.example.sandbox.domain.Movie

class MovieResponseApiMapper: Mapper<MovieResponse, Movie>() {

    override fun map(from: MovieResponse): Movie {
        return Movie(
            rating = from.vote_average,
            title = from.title,
            description = from.overview,
            imageUrl = image_url + from.poster_path
        )
    }
}