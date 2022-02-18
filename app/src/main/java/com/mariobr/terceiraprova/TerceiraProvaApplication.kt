package com.mariobr.terceiraprova

import android.app.Application
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.database.repositoryLocal.LocalRepository
import com.mariobr.terceiraprova.web.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TerceiraProvaApplication:Application() {


    val database by lazy { AppDatabase.invoke(this) }
    val localRepository by lazy { LocalRepository(database.animeDao()) }

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TerceiraProvaApplication)
            modules(appModules)
        }
    }
}