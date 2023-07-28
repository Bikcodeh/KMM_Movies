package com.bikcodeh.kmmmovies.util

import com.bikcodeh.kmmmovies.di.getSharedModules
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(getSharedModules())
    }
}