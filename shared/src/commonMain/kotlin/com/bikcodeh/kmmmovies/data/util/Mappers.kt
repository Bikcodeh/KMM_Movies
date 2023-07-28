package com.bikcodeh.kmmmovies.data.util

import com.bikcodeh.kmmmovies.data.remote.dto.MovieDTO
import com.bikcodeh.kmmmovies.domain.model.Movie

internal fun MovieDTO.toMovie() = Movie(id, title, overview, getImageUrl(posterImage), releaseDate)

private fun getImageUrl(posterImage: String) = "https://image.tmdb.org/t/p/w500/$posterImage"