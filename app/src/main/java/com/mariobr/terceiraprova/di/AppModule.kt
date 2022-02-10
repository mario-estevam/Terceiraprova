package com.mariobr.terceiraprova.di



import com.mariobr.terceiraprova.database.repository.AnimeRepository
import com.mariobr.terceiraprova.service.AnimeService
import com.mariobr.terceiraprova.ui.homeWeb.AnimeViewModel
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


private const val URL_BASE = "https://aw-animes-api.herokuapp.com/"

val retrofitModule = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(URL_BASE)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    single<OkHttpClient> {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
    }
    single<AnimeService> { get<Retrofit>().create(AnimeService::class.java) }
}

val repositoryModule = module {
    single<AnimeRepository> { AnimeRepository(get()) }
}

val viewModelModule = module {
    viewModel<AnimeViewModel> { AnimeViewModel(get()) }
}

val appModules = listOf(
    retrofitModule, repositoryModule, viewModelModule
)