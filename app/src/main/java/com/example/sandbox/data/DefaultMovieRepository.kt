package com.example.sandbox.data

import com.example.sandbox.domain.Movie
import com.example.sandbox.domain.MovieRepository
import com.example.sandbox.domain.Response

class DefaultMovieRepository(
    private val movieDataSource: MovieDataSource,
    private val movieResponseApiMapper: MovieResponseApiMapper
) : MovieRepository {

    override suspend fun getMovies(): Response<List<Movie>> = try {
        val response = movieDataSource.getMovies()

        if (response.isSuccessful) {
            Response.Success(response.body()?.results?.map { movieResponseApiMapper.map(it) } ?: emptyList())
        } else {
            Response.Failure(Exception(response.message()))
        }
    } catch (e: Exception) {
        Response.Failure(e)
    }
}