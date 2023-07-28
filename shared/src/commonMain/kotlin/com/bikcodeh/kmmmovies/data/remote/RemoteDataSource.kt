package com.bikcodeh.kmmmovies.data.remote

import com.bikcodeh.kmmmovies.data.remote.api.MovieService
import com.bikcodeh.kmmmovies.util.Dispatcher
import kotlinx.coroutines.withContext

internal class RemoteDataSource(
    private val movieService: MovieService,
    private val dispatcher: Dispatcher
) {
    suspend fun getMovies(page: Int) = withContext(dispatcher.io) {
        movieService.getMovies(page)
    }

    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io) {
        movieService.getMovie(movieId)
    }
}