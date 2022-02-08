package com.mariobr.terceiraprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.mariobr.segundaprova.adapters.NovoAnimeAdapter
import com.mariobr.segundaprova.adapters.NovoRecyclerViewClickListener
import com.mariobr.terceiraprova.database.AppDatabase
import com.mariobr.terceiraprova.databinding.ActivityMainBinding
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.model.AnimeLocal
import com.mariobr.terceiraprova.viewModel.AnimeViewModel
import org.koin.android.viewmodel.ext.android.viewModel
import java.lang.Exception


class MainActivity : AppCompatActivity() {

    private val viewModel:AnimeViewModel by viewModel()
    private val binding by lazy {
      ActivityMainBinding.inflate(layoutInflater)
    }


    private val db:AppDatabase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDatabase::class.java,
            "anime_database")
            .allowMainThreadQueries()
            .build()
    }

       var anime = AnimeLocal()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter  = NovoAnimeAdapter()

        binding.recyclerview.adapter = adapter


        Thread{
            while(true){
                Thread.sleep(2000)
                runOnUiThread{

                    try {
                        viewModel.listarTodos().observe(this, {
                            adapter.animes = it as Array<Anime>
                            viewModel.lista = adapter.animes
//                            anime.nome = viewModel.lista[0].nome
//                            anime.ano = viewModel.lista[0].ano
//                            anime.eps = viewModel.lista[0].eps
//                            anime.classificacao = viewModel.lista[0].classificacao
//                            anime.idioma = viewModel.lista[0].idioma
//                            anime.arcos = viewModel.lista[0].arcos
//                            db.animeDao().inserir(anime)
//                            Log.e("anime", viewModel.lista[0].toString())
                           // inserirLocal()
                            adapter.notifyDataSetChanged()

                        })

                    }catch (e:ArrayIndexOutOfBoundsException ) {
                        Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }.start()

        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout
        binding.recyclerview.addOnItemTouchListener(NovoRecyclerViewClickListener(this,binding.recyclerview, object : NovoRecyclerViewClickListener.onItemClickListener{
            override fun onItemClick(v: View, position: Int) {

            }
            override fun onItemLongClick(v: View, position: Int) {

            }
        }))
    }

    fun inserirLocal(){

        var x = db.animeDao().findById(1)
        Log.e("objeto nome", x.nome)


//    if(viewModel.lista.size == 1) {
//        for (i in 0..viewModel.lista.size) {
//            anime.nome = viewModel.lista[i].nome
//            anime.ano = viewModel.lista[i].ano
//            anime.eps = viewModel.lista[i].eps
//            anime.classificacao = viewModel.lista[i].classificacao
//            anime.idioma = viewModel.lista[i].idioma
//            anime.arcos = viewModel.lista[i].arcos
//            db.animeDao().inserir(anime)
//
//
//        }
//
//    }else{
//
//    }


    }

}