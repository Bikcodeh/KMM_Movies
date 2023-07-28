package com.bikcodeh.kmmmovies.data.repository

import com.bikcodeh.kmmmovies.data.remote.RemoteDataSource
import com.bikcodeh.kmmmovies.data.util.toMovie
import com.bikcodeh.kmmmovies.domain.model.Movie
import com.bikcodeh.kmmmovies.domain.repository.MovieRepository

internal class MovieRepositoryImpl(
    private val remoteDataSource: RemoteDataSource
): MovieRepository {

    override suspend fun getMovies(page: Int): List<Movie> {
        return remoteDataSource.getMovies(page).results.map { it.toMovie() }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return remoteDataSource.getMovie(movieId).toMovie()
    }
}