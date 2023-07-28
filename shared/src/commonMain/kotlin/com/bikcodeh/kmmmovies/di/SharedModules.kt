package com.bikcodeh.kmmmovies.di

import com.bikcodeh.kmmmovies.data.remote.RemoteDataSource
import com.bikcodeh.kmmmovies.data.remote.api.MovieService
import com.bikcodeh.kmmmovies.data.repository.MovieRepositoryImpl
import com.bikcodeh.kmmmovies.domain.repository.MovieRepository
import com.bikcodeh.kmmmovies.domain.usecase.GetMovieUseCase
import com.bikcodeh.kmmmovies.domain.usecase.GetMoviesUseCase
import com.bikcodeh.kmmmovies.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMovieUseCase() }
    factory { GetMoviesUseCase() }
}

private val sharedModules = listOf(
    domainModule,
    dataModule,
    utilityModule
)

fun getSharedModules() = sharedModules