package com.pokedex.domain.usecase

import com.pokedex.domain.model.PokemonDetailResponse
import com.pokedex.domain.model.PokemonMovesResult
import com.pokedex.domain.model.PokemonResult
import com.pokedex.domain.model.PokemonSpecies
import com.pokedex.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PokemonUseCase {
    fun getListPokemon(): Flow<Resource<List<PokemonResult>>>
    fun getSinglePokemon(name: String): Flow<Resource<PokemonDetailResponse>>
    fun getPokemonSpecies(name: String): Flow<Resource<PokemonSpecies>>
    fun getPokemonMoves(name: String): Flow<Resource<PokemonMovesResult>>

    val getPokemonCatched: Flow<List<PokemonDetailResponse>>
    suspend fun insertPokemonCatched(result: PokemonDetailResponse)
    suspend fun deletePokemonCatched(result: PokemonDetailResponse)
    suspend fun deleteAllPokemonCatched()
}