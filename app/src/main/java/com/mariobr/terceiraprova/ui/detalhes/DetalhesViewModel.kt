package com.mariobr.terceiraprova.ui.detalhes

import android.app.Application
import androidx.lifecycle.*
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.database.repositoryLocal.LocalRepository
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.launch

class DetalhesViewModel private constructor(val id:Long, val localRepository: LocalRepository) : ViewModel()  {

    private val _anime = MutableLiveData<AnimeLocal>()
    val anime: LiveData<AnimeLocal>
        get() = _anime

    init {
        getPessoa(id)
    }

    fun getPessoa(id:Long){
        viewModelScope.launch {
            _anime.value = localRepository.listById(id.toInt())
        }
    }

    class Factory(val id:Long, val localRepository: LocalRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(DetalhesViewModel::class.java)) {
                return DetalhesViewModel(id, localRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}