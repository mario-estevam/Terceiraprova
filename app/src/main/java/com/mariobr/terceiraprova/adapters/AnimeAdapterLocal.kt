package com.mariobr.terceiraprova.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.model.AnimeLocal


class AnimeAdapterLocal: RecyclerView.Adapter<AnimeAdapterLocal.AnimeViewHolderr>() {

    var animes: Array<AnimeLocal> = arrayOf<AnimeLocal>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolderr {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.anime_inflater, parent, false)
        return AnimeViewHolderr(view)
    }

    override fun onBindViewHolder(holder: AnimeViewHolderr, position: Int) {
        val anime = animes[position]
        holder.nomeTextView.text = anime.nome
        holder.epsTextView.text = anime.eps.toString()
        holder.anoTextView.text = anime.ano.toString()
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    class AnimeViewHolderr(itemView: View) : RecyclerView.ViewHolder(itemView){
        var nomeTextView = itemView.findViewById<TextView>(R.id.nomeAnime)
        var epsTextView = itemView.findViewById<TextView>(R.id.AnimeEps)
        var anoTextView = itemView.findViewById<TextView>(R.id.AnimeAno)
    }

}

