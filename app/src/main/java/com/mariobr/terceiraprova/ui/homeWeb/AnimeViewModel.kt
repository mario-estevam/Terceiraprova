package com.mariobr.terceiraprova.ui.homeWeb


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.database.repository.AnimeRepository
import com.mariobr.terceiraprova.database.repository.Resultado
import kotlinx.coroutines.launch


class AnimeViewModel(private val repository: AnimeRepository) : ViewModel()  {

    var lista : Array<Anime> =  arrayOf<Anime>()

    fun buscarTodosOsAnimes(id:Long): LiveData<Resultado<Anime?>> =
        repository.buscaAnime(id)

     fun listarTodos(): LiveData<Any?> {
        return repository.buscaAnimes()
    }

    fun recebe(array:Array<Anime>){
        viewModelScope.launch {
            lista = array
        }

    }






}