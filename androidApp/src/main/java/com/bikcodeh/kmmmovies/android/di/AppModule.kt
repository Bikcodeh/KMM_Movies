package com.bikcodeh.kmmmovies.android.di

import com.bikcodeh.kmmmovies.android.detail.DetailViewModel
import com.bikcodeh.kmmmovies.android.home.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { params -> DetailViewModel(get(), movieId = params.get())}
}