package com.pokedex.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.pokedex.domain.utils.Constants.TABLE_POKEMON_ENTITY

@Entity(tableName = TABLE_POKEMON_ENTITY)
data class PokemonDetailResponse(
    @PrimaryKey
    val id: Int,
    val sprites: SpritesPokemon,
    val name: String?,
    val baseExperience: Int?,
    val height: Int?,
    val weight: Int?,
    val moves: List<PokemonMoves>?,
    val types: List<PokemonTypes>?,
    val stats: List<PokemonStats>?
)
