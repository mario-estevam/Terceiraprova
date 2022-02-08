package com.mariobr.terceiraprova.viewModel


import android.app.Application

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.model.AnimeLocal
import com.mariobr.terceiraprova.repository.AnimeRepository
import com.mariobr.terceiraprova.repository.Resultado
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