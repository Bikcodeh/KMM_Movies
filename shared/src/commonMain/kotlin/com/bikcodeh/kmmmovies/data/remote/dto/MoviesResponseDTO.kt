package com.bikcodeh.kmmmovies.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
internal data class MoviesResponseDTO(
    val results: List<MovieDTO>
)
