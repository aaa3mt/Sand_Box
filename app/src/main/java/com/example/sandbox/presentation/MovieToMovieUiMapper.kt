package com.example.sandbox.presentation

import com.example.sandbox.di.Mapper
import com.example.sandbox.domain.Movie

class MovieToMovieUiMapper : Mapper<Movie, MovieUi>() {

    override fun map(from: Movie): MovieUi {
        return MovieUi(
            rating = from.rating,
            title = from.title,
            description = from.description,
            imageUrl = from.imageUrl
        )
    }
}