package com.example.sandbox.domain

data class Movie(
    val rating: Double,
    val title: String,
    val description: String = "No description yet",
    val imageUrl: String = "https://pbs.twimg.com/media/EeGYe1aUYAEYOiA.png"
)