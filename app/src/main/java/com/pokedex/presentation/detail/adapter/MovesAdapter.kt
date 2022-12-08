package com.pokedex.presentation.detail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pokedex.databinding.ItemMovesLayoutBinding
import com.pokedex.domain.model.PokemonMoves
import com.pokedex.utils.DifferRecycler

class MovesAdapter : RecyclerView.Adapter<MovesAdapter.MovesVH>() {

    private var data = listOf<PokemonMoves>()

    class MovesVH(private val binding: ItemMovesLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PokemonMoves) {
            binding.pokemonMoves = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovesVH {
        val binding =
            ItemMovesLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovesVH(binding)
    }

    override fun onBindViewHolder(holder: MovesVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: List<PokemonMoves>) {
        val oldData = DifferRecycler(data, newData)
        val diffUtil = DiffUtil.calculateDiff(oldData)
        data = newData
        diffUtil.dispatchUpdatesTo(this)
    }
}