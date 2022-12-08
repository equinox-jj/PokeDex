package com.pokedex.data.source.remote.network

import com.pokedex.data.source.remote.dto.PokemonDetailResponseDTO
import com.pokedex.data.source.remote.dto.PokemonMovesResponseDTO
import com.pokedex.data.source.remote.dto.PokemonResponseDTO
import com.pokedex.data.source.remote.dto.PokemonSpeciesResponseDTO
import com.pokedex.data.utils.Constants.POKEMON_EP
import com.pokedex.data.utils.Constants.POKEMON_MOVES_EP
import com.pokedex.data.utils.Constants.POKEMON_SPECIES_EP
import com.pokedex.data.utils.Constants.SINGLE_POKEMON_EP
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET(POKEMON_EP)
    suspend fun getListPokemon(
        @Query("limit") limit: Int = 60,
        @Query("offset") offset: Int = 0,
    ): PokemonResponseDTO

    @GET(SINGLE_POKEMON_EP)
    suspend fun getSinglePokemon(
        @Path("name") name: String
    ): PokemonDetailResponseDTO

    @GET(POKEMON_SPECIES_EP)
    suspend fun getPokemonSpecies(
        @Path("name") name: String
    ): PokemonSpeciesResponseDTO

    @GET(POKEMON_MOVES_EP)
    suspend fun getPokemonMoves(
        @Path("name") name: String
    ): PokemonMovesResponseDTO

}