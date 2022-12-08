package com.pokedex.domain.model

data class PokemonMovesResult(
    val name: String?,
    val pp: Int?,
    val power: Int?,
    val accuracy: Int?,
    val typed: PokemonMovesType?
)
