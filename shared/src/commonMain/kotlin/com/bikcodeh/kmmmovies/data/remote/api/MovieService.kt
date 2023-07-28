package com.bikcodeh.kmmmovies.data.remote.api

import com.bikcodeh.kmmmovies.data.remote.api.KtorApi
import com.bikcodeh.kmmmovies.data.remote.dto.MovieDTO
import com.bikcodeh.kmmmovies.data.remote.dto.MoviesResponseDTO
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter

internal class MovieService: KtorApi() {
    suspend fun getMovies(page: Int = 1): MoviesResponseDTO = client.get {
        pathUrl("movie/popular")
        parameter("page", page)
    }.body()

    suspend fun getMovie(movieId: Int): MovieDTO = client.get {
        pathUrl("movie/$movieId")
    }.body()
}