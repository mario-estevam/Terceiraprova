package com.mariobr.terceiraprova.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.mariobr.terceiraprova.database.dao.AnimeDAO
import com.mariobr.terceiraprova.model.AnimeLocal

@Database(entities = [AnimeLocal::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun animeDao(): AnimeDAO

    companion object {
        @Volatile private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDatabase::class.java, "anime_database")
            .fallbackToDestructiveMigration()
            .build()
    }

}