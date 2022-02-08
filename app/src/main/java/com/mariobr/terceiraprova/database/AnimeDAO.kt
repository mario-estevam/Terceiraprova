package com.mariobr.terceiraprova.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.mariobr.terceiraprova.model.AnimeLocal

@Dao
interface AnimeDAO {
    @Insert
    fun inserir(anime: AnimeLocal): Long

    @Delete
    fun delete(anime: AnimeLocal): Int

    @Delete
    fun deletarVarios(vararg anime: AnimeLocal)

    @Query("DELETE FROM tb_anime")
    fun deletaTodos()

    @Update
    fun atualizar(anime: AnimeLocal):Int

    @Query("SELECT * FROM tb_anime")
    fun listAll(): LiveData<List<AnimeLocal>>

    @Query("SELECT * from tb_anime where id=:id")
    fun findById(id: Int): AnimeLocal

    @Query("SELECT * from tb_anime where id=:id")
    fun buscarPorId(id:Int): LiveData<AnimeLocal>


}