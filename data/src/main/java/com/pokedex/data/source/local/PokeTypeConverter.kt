package com.pokedex.data.source.local

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.pokedex.domain.model.PokemonMoves
import com.pokedex.domain.model.PokemonStats
import com.pokedex.domain.model.PokemonTypes
import com.pokedex.domain.model.SpritesPokemon

class PokeTypeConverter {

    private val gson = Gson()

    @TypeConverter
    fun spriteToString(data: SpritesPokemon): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToSpritesPokemon(data: String): SpritesPokemon {
        val listType = object : TypeToken<SpritesPokemon>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun pokemonMovesToString(data: MutableList<PokemonMoves>?): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToPokemonMoves(data: String): MutableList<PokemonMoves>? {
        val listType = object : TypeToken<MutableList<PokemonMoves>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun pokemonTypesToString(data: MutableList<PokemonTypes>?): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToPokemonTypes(data: String): MutableList<PokemonTypes>? {
        val listType = object : TypeToken<MutableList<PokemonTypes>?>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun pokemonStatsToString(data: MutableList<PokemonStats>?): String {
        return gson.toJson(data)
    }

    @TypeConverter
    fun stringToPokemonStats(data: String): MutableList<PokemonStats> ?{
        val listType = object : TypeToken<MutableList<PokemonTypes>?>() {}.type
        return gson.fromJson(data, listType)
    }

}