package com.pokedex.domain.model

data class PokemonResponse(
    val count: Int?,
    val result: List<PokemonResult>
)
