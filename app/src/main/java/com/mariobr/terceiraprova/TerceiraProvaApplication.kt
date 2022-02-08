package com.mariobr.terceiraprova

import android.app.Application
import com.mariobr.terceiraprova.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TerceiraProvaApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TerceiraProvaApplication)
            modules(appModules)
        }
    }
}