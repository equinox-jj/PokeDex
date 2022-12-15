package com.pokedex.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pokedex.domain.model.PokemonResult
import com.pokedex.domain.usecase.PokemonUseCase
import com.pokedex.domain.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val pokemonUseCase: PokemonUseCase
) : ViewModel() {

    private val _state = MutableLiveData<Resource<List<PokemonResult>>>()
    val state: LiveData<Resource<List<PokemonResult>>> = _state

    init {
        getListPokemon()
    }

    fun onRefresh() {
        getListPokemon()
    }

    private fun getListPokemon() {
        viewModelScope.launch {
            pokemonUseCase.getListPokemon()
                .onStart {
                    _state.value = Resource.Loading()
                }
                .catch { exception ->
                    exception.message?.let { message ->
                        _state.value = Resource.Error(message)
                    }
                }
                .collect { resource ->
                    resource.data?.let { result ->
                        _state.value = Resource.Success(result)
                    }
                }
        }
    }

}