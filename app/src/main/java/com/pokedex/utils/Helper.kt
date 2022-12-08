package com.pokedex.utils

import com.pokedex.R
import com.pokedex.domain.model.PokemonTypes

fun pokemonImage(url: String?): String {
    // "https://pokeapi.co/api/v2/pokemon/1/"
    val pokemonId = url?.split("/".toRegex())?.dropLast(1)?.last()
    return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$pokemonId.png"
}

fun getTypeColor(type: PokemonTypes): Pair<Int, Int> {
    return when (type.type?.name?.lowercase()) {
        "fighting" -> Pair(R.color.fighting, R.drawable.ic_fighting_types)
        "flying" -> Pair(R.color.flying, R.drawable.ic_flying_types)
        "poison" -> Pair(R.color.poison, R.drawable.ic_poison_types)
        "ground" -> Pair(R.color.ground, R.drawable.ic_ground_types)
        "rock" -> Pair(R.color.rock, R.drawable.ic_rock_types)
        "bug" -> Pair(R.color.bug, R.drawable.ic_bug_types)
        "ghost" -> Pair(R.color.ghost, R.drawable.ic_ghost_types)
        "steel" -> Pair(R.color.steel, R.drawable.ic_steel_types)
        "fire" -> Pair(R.color.fire, R.drawable.ic_fire_types)
        "water" -> Pair(R.color.water, R.drawable.ic_water_types)
        "grass" -> Pair(R.color.grass, R.drawable.ic_grass_types)
        "electric" -> Pair(R.color.electric, R.drawable.ic_electric_types)
        "psychic" -> Pair(R.color.psychic, R.drawable.ic_psychic_types)
        "ice" -> Pair(R.color.ice, R.drawable.ic_ice_types)
        "dragon" -> Pair(R.color.dragon, R.drawable.ic_dragon_types)
        "fairy" -> Pair(R.color.fairy, R.drawable.ic_fairy_types)
        "dark" -> Pair(R.color.dark, R.drawable.ic_dark_types)
        "normal" -> Pair(R.color.normal, R.drawable.ic_normal_types)
        else -> Pair(R.color.defaults, R.drawable.ic_launcher_foreground)
    }
}