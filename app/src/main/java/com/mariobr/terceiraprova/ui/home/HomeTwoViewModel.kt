package com.mariobr.terceiraprova.ui.home

import android.app.Application
import androidx.lifecycle.*
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.database.repositoryLocal.LocalRepository
import com.mariobr.terceiraprova.model.AnimeLocal
import kotlinx.coroutines.flow.Flow

class HomeTwoViewModel private constructor(localRepository: LocalRepository) : ViewModel() {

    var list: LiveData<List<AnimeLocal>> = localRepository.listAll.asLiveData()

    class Factory(val localRepository: LocalRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(HomeTwoViewModel::class.java)) {
                return HomeTwoViewModel(localRepository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }


}