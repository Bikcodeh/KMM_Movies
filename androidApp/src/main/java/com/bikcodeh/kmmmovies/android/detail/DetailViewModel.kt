package com.bikcodeh.kmmmovies.android.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bikcodeh.kmmmovies.domain.model.Movie
import com.bikcodeh.kmmmovies.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.launch

class DetailViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    movieId: Int
): ViewModel() {
    var uiState by mutableStateOf(DetailScreenState())

    init {
        loadMovie(movieId)
    }

    private fun loadMovie(movieId: Int) {
        viewModelScope.launch {
            uiState = uiState.copy(loading = true)

            uiState = try {
                val movie = getMovieUseCase(movieId)
                uiState.copy(loading = false, movie = movie)
            } catch (e: Exception) {
                uiState.copy(loading = false, errorMessage = "Error retrieving movie")
            }
        }
    }

}

data class DetailScreenState(
    var loading: Boolean = false,
    var movie: Movie? = null,
    var errorMessage: String? = null
)