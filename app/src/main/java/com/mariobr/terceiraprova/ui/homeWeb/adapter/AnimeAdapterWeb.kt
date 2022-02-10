package com.mariobr.terceiraprova.ui.homeWeb.adapter


import android.view.LayoutInflater

import android.view.ViewGroup

import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.databinding.AnimeInflater2Binding


import com.mariobr.terceiraprova.model.Anime


class AnimeAdapterWeb: ListAdapter<Anime, AnimeAdapterWeb.AnimeViewHolder>(AnimeDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder.from(parent) // escolhe view holder
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = currentList[position]
        holder.bind(anime) //invoca metodo de binding

    }

    class AnimeViewHolder private constructor(var binding: AnimeInflater2Binding) : RecyclerView.ViewHolder(binding.root){

        fun bind(anime: Anime){
            binding.anime = anime//fazendo de fato binding
        }

        companion object{  //instanciação
            fun from(parent:ViewGroup): AnimeViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding:AnimeInflater2Binding = DataBindingUtil.inflate(inflater, R.layout.anime_inflater2, parent,false)
                return AnimeViewHolder(binding)
            }
        }

    }

    class AnimeDiffCallBack: DiffUtil.ItemCallback<Anime>(){
        override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
            return oldItem == newItem
        }
    }

}

