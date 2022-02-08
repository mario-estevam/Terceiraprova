package com.mariobr.terceiraprova.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.model.AnimeLocal

class HomeTwoViewModel(application: Application) : AndroidViewModel(application)  {

    var listaAnimes : LiveData<List<AnimeLocal>>?= null
    val animeDAO = AppDatabase.getDatabase(application).animeDao()

    init {
        listaAnimes = animeDAO.listAll()
    }



}