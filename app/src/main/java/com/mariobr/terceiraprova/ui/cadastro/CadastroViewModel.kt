package com.mariobr.terceiraprova.ui.cadastro


import androidx.lifecycle.*
import com.mariobr.terceiraprova.database.repository.AnimeRepository
import com.mariobr.terceiraprova.database.repositoryLocal.LocalRepository
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.launch


class CadastroViewModel private constructor(private val localRepository: LocalRepository) : ViewModel() {

    var anime: AnimeLocal = AnimeLocal()
    //o botão de clique não invoca mais uma alterção no viewModel, mas ele vai alterar uma váriavel no view model
    //e com essa alteração é disparado um evento, que aqui no caso seria de cadastrar um anime

    private var _eventCadastroAnime = MutableLiveData<Boolean>(false) // é definido como false pra informar que o evento ainda não começou
    val eventCadastroAnime: LiveData<Boolean> //para que nenhum outro lugar além deste viewModel acesse a variável de _event, é definido essa variável do tipo LiveData
        get() = _eventCadastroAnime

    fun cadastroAnime() {
        viewModelScope.launch {
            localRepository.insert(anime)
        }
        _eventCadastroAnime.value = true //indica que o evento está ocorrendo
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