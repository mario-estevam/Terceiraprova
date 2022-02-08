package com.mariobr.terceiraprova.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.launch

class CadastroViewModel(application: Application) : AndroidViewModel(application) {

    var anime = AnimeLocal()
    val db = AppDatabase.getDatabase(application).animeDao()

    fun cadastraAnime(){
        viewModelScope.launch {
            db.inserir(anime)
        }
    }

}