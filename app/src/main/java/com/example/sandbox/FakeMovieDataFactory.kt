package com.example.sandbox

import com.example.sandbox.domain.Movie

class FakeMovieDataFactory {

    fun getMovieList(): List<Movie> {
        return listOf(
            Movie(rating = 9.2, title = "Tenet"),
            Movie(rating = 9.2, title = "Tenet"),
            Movie(rating = 9.2, title = "Tenet"),
            Movie(rating = 9.2, title = "Tenet"),
            Movie(rating = 9.2, title = "Tenet"),
            Movie(rating = 9.2, title = "Tenet"),
            Movie(rating = 9.2, title = "Tenet"),
        )
    }
}