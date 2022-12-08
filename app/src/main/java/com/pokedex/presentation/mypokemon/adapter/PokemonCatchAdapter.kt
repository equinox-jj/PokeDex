package com.pokedex.presentation.mypokemon.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.pokedex.databinding.ItemMyPokemonListBinding
import com.pokedex.domain.model.PokemonDetailResponse
import com.pokedex.utils.DifferRecycler

class PokemonCatchAdapter : RecyclerView.Adapter<PokemonCatchAdapter.MyPokemonVH>() {

    private var data = listOf<PokemonDetailResponse>()

    class MyPokemonVH(private val binding: ItemMyPokemonListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(data: PokemonDetailResponse) {
            binding.myPokemonList = data
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyPokemonVH {
        val binding = ItemMyPokemonListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyPokemonVH(binding)
    }

    override fun onBindViewHolder(holder: MyPokemonVH, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    fun setData(newData: List<PokemonDetailResponse>) {
        val oldData = DifferRecycler(data, newData)
        val diffUtil = DiffUtil.calculateDiff(oldData)
        data = newData
        diffUtil.dispatchUpdatesTo(this)
    }
}