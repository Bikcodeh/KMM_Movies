package com.bikcodeh.kmmmovies.android

import android.app.Application
import com.bikcodeh.kmmmovies.android.di.appModule
import com.bikcodeh.kmmmovies.di.getSharedModules
import org.koin.core.context.startKoin

class KMMMovies: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(appModule + getSharedModules())
        }
    }
}