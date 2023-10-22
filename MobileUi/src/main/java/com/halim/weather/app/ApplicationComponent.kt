package com.halim.weather.app

import android.app.Application
import com.halim.cache.di.cacheModule
import com.halim.data.di.dataModule
import com.halim.domain.di.domainModule
import com.halim.presentation.di.presentationModule
import com.halim.remote.di.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin



class ApplicationComponent : Application() {
    override fun onCreate() {
        super.onCreate()

        setupKoin()
    }

    private fun setupKoin() {
        startKoin {
            androidLogger(org.koin.core.logger.Level.DEBUG)
            androidContext(this@ApplicationComponent)
            modules(listOf(presentationModule, domainModule, dataModule, remoteModule, cacheModule))
        }
    }


}