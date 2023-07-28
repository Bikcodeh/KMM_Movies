package com.bikcodeh.kmmmovies.domain.repository

import com.bikcodeh.kmmmovies.domain.model.Movie

internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>
    suspend fun getMovie(movieId: Int): Movie
}