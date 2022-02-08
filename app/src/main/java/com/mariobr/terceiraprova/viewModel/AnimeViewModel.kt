package com.mariobr.terceiraprova.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.repository.AnimeRepository
import com.mariobr.terceiraprova.repository.Resultado


class AnimeViewModel(private val repository: AnimeRepository) : ViewModel() {

    var lista : Array<Anime?> =  arrayOfNulls<Anime>(10)

    fun buscarTodosOsAnimes(id:Long): LiveData<Resultado<Anime?>> =
        repository.buscaAnime(id)

     fun listarTodos(): LiveData<Any?> {
        return repository.buscaAnimes()
    }
}