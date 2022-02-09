package com.mariobr.terceiraprova.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.model.Anime


class NovoAnimeAdapter: RecyclerView.Adapter<NovoAnimeAdapter.AnimeViewHolder>() {

    var animes: Array<Anime> = arrayOf<Anime>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_inflater2, parent, false)
        return AnimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        val anime = animes[position]
        holder.nomeTextView.text = anime.nome
        holder.epsTextView.text = anime.eps.toString()
        holder.anoTextView.text = anime.ano.toString()
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    class AnimeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nomeTextView = itemView.findViewById<TextView>(R.id.nomeAnime)
        var epsTextView = itemView.findViewById<TextView>(R.id.AnimeEps)
        var anoTextView = itemView.findViewById<TextView>(R.id.AnimeAno)
    }

}

