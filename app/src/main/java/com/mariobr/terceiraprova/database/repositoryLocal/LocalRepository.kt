package com.mariobr.terceiraprova.database.repositoryLocal

import com.mariobr.terceiraprova.database.dao.AnimeDAO
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.flow.Flow

class LocalRepository(private val animeDao: AnimeDAO) {

    val listAll: Flow<List<AnimeLocal>> = animeDao.listAll()

    suspend fun insert(a: AnimeLocal){
        animeDao.inserir(a)
    }
    suspend fun delete(a: AnimeLocal){
        animeDao.delete(a)
    }
    suspend fun update(a: AnimeLocal){
        animeDao.atualizar(a)
    }
    suspend fun listById(id: Int): AnimeLocal{
        return animeDao.findById(id)
    }


}