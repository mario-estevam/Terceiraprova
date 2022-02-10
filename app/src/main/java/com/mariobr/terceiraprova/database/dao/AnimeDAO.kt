package com.mariobr.terceiraprova.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDAO {
    @Insert
    suspend fun inserir(anime: AnimeLocal): Long

    @Delete
    suspend fun delete(anime: AnimeLocal): Int

    @Delete
    fun deletarVarios(vararg anime: AnimeLocal)

    @Query("DELETE FROM tb_anime")
    fun deletaTodos()

    @Update
    suspend fun atualizar(anime: AnimeLocal):Int

    @Query("SELECT * FROM tb_anime")
    fun listAll(): Flow<List<AnimeLocal>>

    @Query("SELECT * FROM tb_anime")
    fun buscarAnimes(): Array<AnimeLocal>

    @Query("SELECT * from tb_anime where id=:id")
    suspend fun findById(id: Int): AnimeLocal

    @Query("SELECT * from tb_anime where id=:id")
    fun buscarPorId(id:Int): LiveData<AnimeLocal>


}