package com.pokedex.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pokedex.databinding.ItemPokemonVerticalBinding
import com.pokedex.domain.model.PokemonResult
import com.pokedex.utils.DifferRecycler

class PokemonListAdapter : RecyclerView.Adapter<PokemonListAdapter.HomeVH>() {

    private var data = listOf<PokemonResult>()

    class HomeVH(private val binding: ItemPokemonVerticalBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PokemonResult) {
            binding.pokemonResult = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeVH {
        val binding = ItemPokemonVerticalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HomeVH(binding)
    }

    override fun onBindViewHolder(holder: HomeVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: List<PokemonResult>) {
        val oldData = DifferRecycler(data, newData)
        val diffUtil = DiffUtil.calculateDiff(oldData)
        data = newData
        diffUtil.dispatchUpdatesTo(this)
    }
}