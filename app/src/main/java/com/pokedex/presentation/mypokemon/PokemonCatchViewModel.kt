package com.pokedex.presentation.mypokemon

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.pokedex.domain.usecase.PokemonUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonCatchViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase
) : ViewModel() {

    val getPokemonCatched = pokemonUseCase.getPokemonCatched.asLiveData()

    fun removeAllPokemon() {
        viewModelScope.launch {
            pokemonUseCase.deleteAllPokemonCatched()
        }
    }

}