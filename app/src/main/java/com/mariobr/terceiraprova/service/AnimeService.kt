package com.mariobr.terceiraprova.service

import androidx.lifecycle.MutableLiveData
import com.mariobr.terceiraprova.model.Anime

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path


interface AnimeService {

    @GET("/animes/{id}")
    suspend fun buscarAnimeById(@Path("id") id:Long): Response<Anime>

    @GET("/animes")
    suspend fun buscarAnimes(): Response<MutableList<Anime>>



}