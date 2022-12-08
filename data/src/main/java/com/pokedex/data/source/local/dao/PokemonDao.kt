package com.pokedex.data.source.local.dao

import androidx.room.*
import com.pokedex.domain.model.PokemonDetailResponse
import kotlinx.coroutines.flow.Flow

@Dao
interface PokemonDao {

    @Query("SELECT * FROM pokemon_entity ORDER BY id ASC")
    fun getPokemonCatched(): Flow<List<PokemonDetailResponse>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPokemonCatched(entity: PokemonDetailResponse)

    @Delete
    suspend fun deletePokemonCatched(entity: PokemonDetailResponse)

    @Query("DELETE FROM pokemon_entity")
    suspend fun deleteAllPokemonCatched()

}