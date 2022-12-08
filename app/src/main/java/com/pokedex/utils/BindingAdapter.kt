package com.pokedex.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.BindingAdapter
import androidx.navigation.findNavController
import androidx.palette.graphics.Palette
import coil.load
import com.google.android.material.card.MaterialCardView
import com.pokedex.presentation.home.HomeFragmentDirections
import com.pokedex.presentation.mypokemon.PokemonCatchFragmentDirections

object BindingAdapters {

    @BindingAdapter("app:home_to_detail")
    @JvmStatic
    fun navigateToDetail(view: MaterialCardView, pokemonName: String) {
        view.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(pokemonName)
            it.findNavController().navigate(action)
        }
    }

    @BindingAdapter("app:favorite_to_detail")
    @JvmStatic
    fun navigateFavoriteToDetail(view: MaterialCardView, pokemonName: String) {
        view.setOnClickListener {
            val action = PokemonCatchFragmentDirections.actionPokemonCatchFragmentToDetailFragment(pokemonName)
            it.findNavController().navigate(action)
        }
    }

    @BindingAdapter("app:pokemon_name")
    @JvmStatic
    fun pokemonNameCaps(view: TextView, pokemonName: String) {
        view.text = pokemonName.replaceFirstChar { it.uppercase() }
    }

    @BindingAdapter("app:pokemon_image", "app:pokemon_card")
    @JvmStatic
    fun pokemonImage(view: ImageView, pokemonId: String, paletteCard: MaterialCardView) {
        view.load(pokemonImage(pokemonId)) {
            allowHardware(false)
            crossfade(200)
            listener(
                onSuccess = { _, result ->
                    Palette.Builder(result.drawable.toBitmap()).generate { palette ->
                        val rgb = palette?.dominantSwatch?.rgb
                        if (rgb != null) {
                            paletteCard.setCardBackgroundColor(rgb)
                        }
                    }
                }
            )
        }
    }

    @BindingAdapter("app:my_pokemon_image", "app:my_pokemon_card")
    @JvmStatic
    fun myPokemonImage(view: ImageView, artWork: String, paletteCard: MaterialCardView) {
        view.load(artWork) {
            allowHardware(false)
            crossfade(200)
            listener(
                onSuccess = { _, result ->
                    Palette.Builder(result.drawable.toBitmap()).generate { palette ->
                        val rgb = palette?.dominantSwatch?.rgb
                        if (rgb != null) {
                            paletteCard.setCardBackgroundColor(rgb)
                        }
                    }
                }
            )
        }
    }

    @BindingAdapter("app:pokemon_moves")
    @JvmStatic
    fun pokemonMovesText(view: TextView, movesName: String) {
        view.text = movesName
            .replace("-", "  ")
            .split(" ")
            .joinToString(" ") { it.replaceFirstChar { first -> first.uppercase() } }
    }


}