package com.mariobr.terceiraprova.ui.cadastro


import androidx.lifecycle.*
import com.mariobr.terceiraprova.database.repository.AnimeRepository
import com.mariobr.terceiraprova.database.repositoryLocal.LocalRepository
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.launch


class CadastroViewModel private constructor(private val localRepository: LocalRepository) : ViewModel() {

    var anime: AnimeLocal = AnimeLocal()
    private var _eventCadastroAnime = MutableLiveData<Boolean>(false)
    val eventCadastroAnime: LiveData<Boolean>
        get() = _eventCadastroAnime

    fun cadastroAnime() {
        viewModelScope.launch {
            localRepository.insert(anime)
        }
        _eventCadastroAnime.value = true
    }

    fun onCadastroAnimeComplete(){
        _eventCadastroAnime.value = false
    }

    class Factory(val localRepository: LocalRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(CadastroViewModel::class.java)) {
                return CadastroViewModel(localRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

}