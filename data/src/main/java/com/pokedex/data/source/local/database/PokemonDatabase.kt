package com.pokedex.data.source.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.pokedex.data.source.local.PokeTypeConverter
import com.pokedex.data.source.local.dao.PokemonDao
import com.pokedex.domain.model.PokemonDetailResponse

@Database(entities = [PokemonDetailResponse::class], version = 1, exportSchema = false)
@TypeConverters(PokeTypeConverter::class)
abstract class PokemonDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

}