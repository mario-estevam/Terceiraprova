package com.mariobr.terceiraprova.ui.altera

import androidx.lifecycle.*
import com.mariobr.terceiraprova.database.repositoryLocal.LocalRepository
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.launch

class AlteraViewModel private constructor(val id: Long, val localRepository: LocalRepository) : ViewModel() {


    private val _anime = MutableLiveData<AnimeLocal>()
    val anime: LiveData<AnimeLocal>
        get() = _anime

    private var _eventAlteraAnime = MutableLiveData<Boolean>(false)
    val eventAlteraAnime: LiveData<Boolean>
        get() = _eventAlteraAnime

    init {
        getPessoa(id)
    }

    fun alteraAnime(){
        viewModelScope.launch {
            anime.value?.let { localRepository.update(it) }
        }
        _eventAlteraAnime.value = true
    }

    fun onAlteraPessoaComplete(){
        _eventAlteraAnime.value = false
    }

    fun getPessoa(id:Long){
        viewModelScope.launch {
            _anime.value = localRepository.listById(id.toInt())
        }
    }


    class Factory(val id:Long, val localRepository: LocalRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AlteraViewModel::class.java)) {
                return AlteraViewModel(id, localRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}