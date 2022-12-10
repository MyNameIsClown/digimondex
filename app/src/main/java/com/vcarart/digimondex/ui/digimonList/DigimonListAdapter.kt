package com.vcarart.digimondex.ui.digimonList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.vcarart.digimondex.R
import com.vcarart.digimondex.model.api.DigimonResult
import kotlinx.android.synthetic.main.card_digimon_search.view.*

class DigimonListAdapter(val pokemonClick: (Int) -> Unit): RecyclerView.Adapter<DigimonListAdapter.SearchViewHolder>() {
    var pokemonList: List<DigimonResult> = emptyList<DigimonResult>()

    fun setData(list: List<DigimonResult>){
        pokemonList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        return SearchViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.card_digimon_search, parent,false))
    }

    override fun getItemCount(): Int {
        return pokemonList.size
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        val pokemon = pokemonList[position]
        holder.itemView.pokemonText.text = "#${pokemon.id} - ${pokemon.name}"

        holder.itemView.setOnClickListener { pokemonClick(position + 1) }
    }

    class SearchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
}