package com.mariobr.terceiraprova.viewModel

import android.app.Application
import androidx.lifecycle.*
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.launch

class AlteraViewModel(application: Application, id:Int) : AndroidViewModel(application) {

    val animeDAO = AppDatabase.getDatabase(application).animeDao()

    lateinit var anime: LiveData<AnimeLocal>

    init {
        viewModelScope.launch {
            anime =  animeDAO.buscarPorId(id)
        }
    }


    fun saveAnime() {
        viewModelScope.launch {
            animeDAO.atualizar(anime.value!!)
        }
    }


    class AlteraFragmentViewModelFactory(val application: Application, val id:Int) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(application, id) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}