package com.mariobr.terceiraprova

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.recyclerview.widget.LinearLayoutManager
import com.mariobr.segundaprova.adapters.NovoAnimeAdapter
import com.mariobr.segundaprova.adapters.NovoRecyclerViewClickListener
import com.mariobr.terceiraprova.databinding.ActivityMainBinding
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.viewModel.AnimeViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel:AnimeViewModel by viewModel()
    private val binding by lazy {
      ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter  = NovoAnimeAdapter()

        binding.recyclerview.adapter = adapter

        viewModel.listarTodos().observe(this, {
            adapter.animes = it as Array<Anime>
            adapter.notifyDataSetChanged()
        })

        val layout = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerview.layoutManager = layout
        binding.recyclerview.addOnItemTouchListener(NovoRecyclerViewClickListener(this,binding.recyclerview, object : NovoRecyclerViewClickListener.onItemClickListener{
            override fun onItemClick(v: View, position: Int) {

            }
            override fun onItemLongClick(v: View, position: Int) {

            }
        }))
    }


}