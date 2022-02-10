package com.mariobr.terceiraprova.database.repository

import androidx.lifecycle.liveData

import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.service.AnimeService
import java.net.ConnectException


sealed class Resultado<out R> {
    data class Sucesso<out T>(val dado: T?) : Resultado<T?>()
    data class Erro(val exception: Exception) : Resultado<Nothing>()
}

sealed class Resultado2<out R> {
    data class Sucesso<out T>(val dado: Anime?) : Resultado2<List<Anime?>>()
    data class Erro(val exception: Exception) : Resultado2<Nothing>()
}

class AnimeRepository (private val service: AnimeService) {

    fun buscaAnime(id:Long) = liveData {
        try {
            val resposta = service.buscarAnimeById(id)
            if(resposta.isSuccessful){
                emit(Resultado.Sucesso(dado = resposta.body()))
            } else {
                emit(Resultado.Erro(exception = Exception("Falha ao buscar o anime")))
            }
        } catch (e: ConnectException) {
            emit(Resultado.Erro(exception = Exception("Falha na comunicação com API")))
        }
        catch (e: Exception) {
            emit(Resultado.Erro(exception = e))
        }
    }

    fun buscaAnimes() = liveData {

        try {
            val resposta = service.buscarAnimes()
            if(resposta.isSuccessful){
                emit(resposta.body())
            } else {
                emit(Resultado2.Erro(exception = Exception("Falha ao buscar o anime")))
            }
        } catch (e: ConnectException) {
            emit(Resultado2.Erro(exception = Exception("Falha na comunicação com API")))
        }
        catch (e: Exception) {
            emit(Resultado2.Erro(exception = e))
        }
    }






}