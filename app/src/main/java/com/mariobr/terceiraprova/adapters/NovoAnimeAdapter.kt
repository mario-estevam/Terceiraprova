package com.mariobr.segundaprova.adapters


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.model.Anime


class NovoAnimeAdapter : RecyclerView.Adapter<NovoAnimeViewHolder>() {

   var animes: Array<Anime> = arrayOf<Anime>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NovoAnimeViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.anime_inflater, parent, false)
        val holder = NovoAnimeViewHolder(v)
        return holder
    }



    override fun onBindViewHolder(holder: NovoAnimeViewHolder, position: Int) {
        val animeEscolhido = animes.get(position)
        holder.ano.text = animeEscolhido!!.ano.toString()
        holder.nomeAnime.text = animeEscolhido!!.nome
        holder.eps.text = animeEscolhido!!.eps.toString()
    }

    override fun getItemCount(): Int {
        return animes.size
    }

    fun setAnimeList(animes2: Array<Anime>) {
        animes = animes2
        notifyDataSetChanged()
    }
}

class NovoAnimeViewHolder(v: View) : RecyclerView.ViewHolder(v) {
    val ano = v.findViewById<TextView>(R.id.ano)
    val nomeAnime = v.findViewById<TextView>(R.id.nomeAnime)
    val eps = v.findViewById<TextView>(R.id.eps)
}