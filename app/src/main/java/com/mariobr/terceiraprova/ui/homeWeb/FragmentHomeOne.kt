package com.mariobr.terceiraprova.ui.homeWeb



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.ui.homeWeb.adapter.AnimeAdapterWeb

import com.mariobr.terceiraprova.databinding.FragmentHomeOneBinding
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.model.AnimeLocal
import org.koin.android.viewmodel.ext.android.viewModel


class FragmentHomeOne : Fragment() {

    private val viewModel: AnimeViewModel by viewModel()
    lateinit var binding: FragmentHomeOneBinding

    var anime = AnimeLocal()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_one, container, false)
        val adapter  = AnimeAdapterWeb()

        binding.recyclerView.adapter = adapter
        viewModel.listarTodos().observe(viewLifecycleOwner, { list ->
            adapter.submitList(list as MutableList<Anime>?)
        })

       return binding.root
    }


}



