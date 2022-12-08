package com.pokedex.presentation.detail

import androidx.lifecycle.*
import com.pokedex.domain.model.PokemonDetailResponse
import com.pokedex.domain.model.PokemonSpecies
import com.pokedex.domain.usecase.PokemonUseCase
import com.pokedex.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase
) : ViewModel() {

    private val _detailState = MutableLiveData<Resource<PokemonDetailResponse>>()
    val detailState: LiveData<Resource<PokemonDetailResponse>> = _detailState

    private val _speciesState = MutableLiveData<Resource<PokemonSpecies>>()
    val speciesState: LiveData<Resource<PokemonSpecies>> = _speciesState

    val getPokemonCatched = pokemonUseCase.getPokemonCatched.asLiveData()

    fun insertPokemonCatched(data: PokemonDetailResponse) {
        viewModelScope.launch {
            pokemonUseCase.insertPokemonCatched(data)
        }
    }

    fun deletePokemonCatched(data: PokemonDetailResponse) {
        viewModelScope.launch {
            pokemonUseCase.deletePokemonCatched(data)
        }
    }

    fun onRefresh(name: String) {
        getSinglePokemon(name)
    }

    fun getSinglePokemon(name: String) {
        viewModelScope.launch {
            pokemonUseCase.getSinglePokemon(name)
                .onStart {
                    _detailState.value = Resource.Loading()
                }
                .catch { exception ->
                    exception.message?.let { message ->
                        _detailState.value = Resource.Error(message)
                    }
                }
                .collect { response ->
                    response.data?.let { result ->
                        _detailState.value = Resource.Success(result)
                    }
                }
        }
    }

    fun getPokemonSpecies(name: String) {
        viewModelScope.launch {
            pokemonUseCase.getPokemonSpecies(name)
                .onStart {
                    _speciesState.value = Resource.Loading()
                }
                .catch { exception ->
                    exception.message?.let { message ->
                        _speciesState.value = Resource.Error(message)
                    }
                }
                .collect { response ->
                    response.data?.let { result ->
                        _speciesState.value = Resource.Success(result)
                    }
                }
        }
    }

}