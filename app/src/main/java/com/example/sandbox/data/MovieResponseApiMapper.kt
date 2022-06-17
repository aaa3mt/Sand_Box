package com.example.sandbox.data

import com.example.sandbox.di.Mapper
import com.example.sandbox.domain.Movie
import com.example.sandbox.presentation.MovieUi

class MovieResponseApiMapper: Mapper<MovieResponse, Movie>() {

    override fun map(from: MovieResponse): Movie {
        return Movie(
            rating = from.vote_average,
            title = from.title,
            description = from.overview,
            imageUrl = image_url + from.posterPath
        )
    }
}