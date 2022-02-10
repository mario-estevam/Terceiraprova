package com.mariobr.terceiraprova.ui.home.adapter


import android.view.LayoutInflater

import android.view.ViewGroup


import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.databinding.AnimeInflaterBinding

import com.mariobr.terceiraprova.model.AnimeLocal


class AnimeAdapterLocal: ListAdapter<AnimeLocal, AnimeAdapterLocal.AnimeViewHolderr>(
    AnimeDiffCallBack()
) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolderr {
        return AnimeViewHolderr.from(parent) // escolhe view holder
    }

    override fun onBindViewHolder(holder: AnimeViewHolderr, position: Int) {
        val anime = currentList[position]
        holder.bind(anime) //invoca metodo de binding

    }

    class AnimeViewHolderr private constructor(var binding: AnimeInflaterBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(anime:AnimeLocal){
            binding.anime = anime //fazendo de fato binding
        }

        companion object{  //instanciação
            fun from(parent:ViewGroup): AnimeViewHolderr {
                val inflater = LayoutInflater.from(parent.context)
                val binding:AnimeInflaterBinding = DataBindingUtil.inflate(inflater, R.layout.anime_inflater, parent,false)
                return AnimeViewHolderr(binding)
            }
        }

    }

    class AnimeDiffCallBack:DiffUtil.ItemCallback<AnimeLocal>(){
        override fun areItemsTheSame(oldItem: AnimeLocal, newItem: AnimeLocal): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: AnimeLocal, newItem: AnimeLocal): Boolean {
            return oldItem == newItem
        }
    }

}

