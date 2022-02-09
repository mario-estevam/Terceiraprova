package com.mariobr.terceiraprova.viewModel

import android.app.Application
import androidx.lifecycle.*
import androidx.room.Room
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.launch

class AlteraViewModel(application: Application, id:Int) : AndroidViewModel(application) {


   private val db:AppDatabase by lazy{
       Room.databaseBuilder(
           application.applicationContext,
           AppDatabase::class.java,
           "anime_database")
           .build()
   }

    lateinit var anime: LiveData<AnimeLocal>
    private var _eventAlteraPessoa = MutableLiveData<Boolean>(false)
    val eventAlteraPessoa:LiveData<Boolean>
            get() = _eventAlteraPessoa

    init {
        viewModelScope.launch {
            anime =  db.animeDao().buscarPorId(id)
        }
    }


    fun onAlteraAnimeStart() {
        viewModelScope.launch {
            db.animeDao().atualizar(anime.value!!)
        }
        _eventAlteraPessoa.value = true
    }

    fun onAlteraAnimeComplete(){
        _eventAlteraPessoa.value = false
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