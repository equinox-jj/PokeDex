package com.pokedex.data.repository

import com.pokedex.data.mapper.moveResponseDtoToDomain
import com.pokedex.data.mapper.responseDetailDtoToDomain
import com.pokedex.data.mapper.resultDtoToDomain
import com.pokedex.data.mapper.speciesDtoToDOmain
import com.pokedex.data.source.local.dao.PokemonDao
import com.pokedex.data.source.remote.network.ApiService
import com.pokedex.domain.model.PokemonDetailResponse
import com.pokedex.domain.model.PokemonMovesResult
import com.pokedex.domain.model.PokemonResult
import com.pokedex.domain.model.PokemonSpecies
import com.pokedex.domain.repository.PokemonRepository
import com.pokedex.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okio.IOException
import retrofit2.HttpException
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val pokemonDao: PokemonDao
) : PokemonRepository {

    override fun getListPokemon(): Flow<Resource<List<PokemonResult>>> = flow {
        emit(Resource.Loading())
        try {
            val result = apiService.getListPokemon().results.map { it.resultDtoToDomain() }
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        }
    }.flowOn(Dispatchers.IO)

    override fun getSinglePokemon(name: String): Flow<Resource<PokemonDetailResponse>> = flow {
        emit(Resource.Loading())
        try {
            val result = apiService.getSinglePokemon(name).responseDetailDtoToDomain()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        }
    }.flowOn(Dispatchers.IO)

    override fun getPokemonSpecies(name: String): Flow<Resource<PokemonSpecies>> = flow {
        emit(Resource.Loading())
        try {
            val result = apiService.getPokemonSpecies(name).speciesDtoToDOmain()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        }
    }.flowOn(Dispatchers.IO)

    override fun getPokemonMoves(name: String): Flow<Resource<PokemonMovesResult>> = flow {
        emit(Resource.Loading())
        try {
            val result = apiService.getPokemonMoves(name).moveResponseDtoToDomain()
            emit(Resource.Success(result))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: IOException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: ""))
        }
    }.flowOn(Dispatchers.IO)

    override val getPokemonCatched: Flow<List<PokemonDetailResponse>> = pokemonDao.getPokemonCatched()
    override suspend fun insertPokemonCatched(result: PokemonDetailResponse) = pokemonDao.insertPokemonCatched(result)
    override suspend fun deletePokemonCatched(result: PokemonDetailResponse) = pokemonDao.deletePokemonCatched(result)
    override suspend fun deleteAllPokemonCatched() = pokemonDao.deleteAllPokemonCatched()

}