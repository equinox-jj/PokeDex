package com.pokedex.domain.usecase

import com.pokedex.domain.model.PokemonDetailResponse
import com.pokedex.domain.model.PokemonMovesResult
import com.pokedex.domain.model.PokemonResult
import com.pokedex.domain.model.PokemonSpecies
import com.pokedex.domain.repository.PokemonRepository
import com.pokedex.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class PokemonInteractor @Inject constructor(
    private val pokemonRepository: PokemonRepository
) : PokemonUseCase {
    override fun getListPokemon(): Flow<Resource<List<PokemonResult>>> = pokemonRepository.getListPokemon()
    override fun getSinglePokemon(name: String): Flow<Resource<PokemonDetailResponse>> = pokemonRepository.getSinglePokemon(name)
    override fun getPokemonSpecies(name: String): Flow<Resource<PokemonSpecies>> = pokemonRepository.getPokemonSpecies(name)
    override fun getPokemonMoves(name: String): Flow<Resource<PokemonMovesResult>> = pokemonRepository.getPokemonMoves(name)

    override val getPokemonCatched: Flow<List<PokemonDetailResponse>> = pokemonRepository.getPokemonCatched
    override suspend fun insertPokemonCatched(result: PokemonDetailResponse) = pokemonRepository.insertPokemonCatched(result)
    override suspend fun deletePokemonCatched(result: PokemonDetailResponse) = pokemonRepository.deletePokemonCatched(result)
    override suspend fun deleteAllPokemonCatched() = pokemonRepository.deleteAllPokemonCatched()
}