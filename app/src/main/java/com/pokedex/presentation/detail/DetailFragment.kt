package com.pokedex.presentation.detail

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.graphics.drawable.toBitmap
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import androidx.palette.graphics.Palette
import coil.load
import com.google.android.material.snackbar.Snackbar
import com.pokedex.R
import com.pokedex.databinding.FragmentDetailBinding
import com.pokedex.domain.model.FlavorTextEntries
import com.pokedex.domain.model.PokemonDetailResponse
import com.pokedex.domain.model.PokemonTypes
import com.pokedex.domain.utils.Resource
import com.pokedex.presentation.detail.adapter.MovesAdapter
import com.pokedex.utils.getTypeColor
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    private val args by navArgs<DetailFragmentArgs>()
    private val detailViewModel by viewModels<DetailViewModel>()
    private var movesAdapter: MovesAdapter? = null

    private lateinit var pokemonDetailResponse: PokemonDetailResponse
    private var pokemonName = ""
    private var isCatched = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentDetailBinding.bind(view)

        checkPokemonCatched()
        initObserver()
        initMovesRecycler()
        setupListener()
    }

    private fun setupListener() {
        val pokeName = args.pokemonName
        binding.ivDetailBack.setOnClickListener {
            it.findNavController().popBackStack()
        }
        binding.refreshDetail.setOnRefreshListener {
            detailViewModel.onRefresh(pokeName)
            binding.refreshDetail.isRefreshing = false
        }
        binding.ivPokemonCatch.setOnClickListener {
            val percentage = Math.random() < 0.5 // Kalo kurang dari 50% false

            if (percentage) {
                insertPokemonCatched()
                Toast.makeText(
                    context,
                    "You Caught ${pokemonName.replaceFirstChar { it.uppercase() }}!!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(context, "Oops Try Again", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initMovesRecycler() {
        binding.rvPokemonMoves.apply {
            movesAdapter = MovesAdapter()
            adapter = movesAdapter
            setHasFixedSize(true)
        }
    }

    private fun initObserver() {
        val pokeName = args.pokemonName
        detailViewModel.getSinglePokemon(pokeName)
        detailViewModel.getPokemonSpecies(pokeName)
        detailViewModel.detailState.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.pbDetail.visibility = View.VISIBLE
                    binding.constraintDetContent.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.pbDetail.visibility = View.GONE
                    binding.constraintDetContent.visibility = View.VISIBLE
                    response.data?.let { initView(it) }
                }
                is Resource.Error -> {
                    binding.pbDetail.visibility = View.GONE
                    binding.constraintDetContent.visibility = View.GONE
                    Snackbar.make(
                        binding.root,
                        getString(R.string.error_check_connection),
                        Snackbar.LENGTH_INDEFINITE
                    ).show()
                }
            }
        }
        detailViewModel.speciesState.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.tvPokemonDesc.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.tvPokemonDesc.visibility = View.VISIBLE
                    response.data?.flavorTextEntries?.let { setPokemonSpecies(it) }
                }
                is Resource.Error -> {}
            }
        }
    }

    private fun initView(data: PokemonDetailResponse) {
        binding.apply {
            data.moves?.let { movesAdapter?.setData(it) }
            tvPokeNumberDet.text = getString(R.string.pokemon_number_format, data.id)
            tvPokeNameDet.text = data.name?.replaceFirstChar { it.uppercase() }
            binding.tvHpPoke.text = data.stats?.get(0)?.baseStat.toString()
            binding.tvAttackPoke.text = data.stats?.get(1)?.baseStat.toString()
            binding.tvDefensePoke.text = data.stats?.get(2)?.baseStat.toString()
            binding.tvSpecialAttackPoke.text = data.stats?.get(3)?.baseStat.toString()
            binding.tvSpecialDefensePoke.text = data.stats?.get(4)?.baseStat.toString()
            binding.tvSpeedPoke.text = data.stats?.get(5)?.baseStat.toString()
            ivPokeImageDet.load(data.sprites.other?.officialArtwork?.frontDefault) {
                allowHardware(false)
                crossfade(200)
                listener(
                    onSuccess = { _, result ->
                        Palette.Builder(result.drawable.toBitmap()).generate { palette ->
                            val rgb = palette?.dominantSwatch?.rgb
                            if (rgb != null) {
                                scrollDetail.setBackgroundColor(rgb)
                            }
                        }
                    }
                )
            }
            setPokemonTypes(data.types)

            pokemonDetailResponse = PokemonDetailResponse(
                id = data.id,
                sprites = data.sprites,
                name = data.name,
                baseExperience = data.baseExperience,
                height = data.height,
                weight = data.weight,
                moves = data.moves,
                types = data.types,
                stats = data.stats
            )
        }
    }

    private fun setPokemonSpecies(species: List<FlavorTextEntries?>) {
        species
            .filterNotNull()
            .filter { it.language?.name?.trim()?.contains("en".lowercase()) == true }
            .take(1)
            .map {
                val format = it.flavorText
                    ?.trim()
                    ?.replace("\n", " ")
                    ?.replace("\u000c", " ")
                    ?.replace("POKéMON", "Pokémon")
                binding.tvPokemonDesc.text = format
            }
    }

    private fun setPokemonTypes(type: List<PokemonTypes>?) {
        type?.forEachIndexed { index, pokemonTypes ->
            val typeName = pokemonTypes.type?.name
            val pokemonType = getTypeColor(pokemonTypes)
            val typeColor = pokemonType.first
            val typeIcon = pokemonType.second

            when (index) {
                0 -> {
                    binding.chipTypes1.text = typeName?.replaceFirstChar { it.uppercase() }
                    binding.chipTypes1.setChipBackgroundColorResource(typeColor)
                    binding.chipTypes1.setChipIconResource(typeIcon)
                }
                1 -> {
                    binding.chipTypes2.text = typeName?.replaceFirstChar { it.uppercase() }
                    binding.chipTypes2.setChipBackgroundColorResource(typeColor)
                    binding.chipTypes2.setChipIconResource(typeIcon)
                }
            }
        }
        if (type?.size == 1) binding.chipTypes2.visibility = View.GONE
        else binding.chipTypes2.visibility = View.VISIBLE
    }

    private fun checkPokemonCatched() {
        detailViewModel.getPokemonCatched.observe(viewLifecycleOwner) { list ->
            try {
                list
                    .filter { it.name == args.pokemonName }
                    .forEach {
                        binding.ivPokemonCatch.setImageResource(R.drawable.img_close_pokeball)
                        binding.tvPokemonCatch.text = getString(R.string.pokemon_caught)
                        binding.btnRelease.visibility = View.VISIBLE
                        binding.btnRelease.setOnClickListener {
                            alertDialog()
                        }
                        pokemonName = it.name!!
                        isCatched = true
                    }
            } catch (e: Exception) {
                isCatched = false
            }
        }
    }

    private fun insertPokemonCatched() {
        detailViewModel.insertPokemonCatched(pokemonDetailResponse)
        isCatched = true
    }

    private fun deletePokemonCatched() {
        detailViewModel.deletePokemonCatched(pokemonDetailResponse)
        isCatched = false
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Release Pokemon")
        builder.setMessage("Are you sure you want to release ${pokemonName.replaceFirstChar { it.uppercase() }}?")
        builder.setPositiveButton("Yes") { _, _ ->
            deletePokemonCatched()
            binding.ivPokemonCatch.setImageResource(R.drawable.img_open_pokeball)
            binding.tvPokemonCatch.text = getString(R.string.click_to_catch_pokemon)
            binding.btnRelease.visibility = View.GONE
            Toast.makeText(
                requireContext(),
                "Successfully released ${pokemonName.replaceFirstChar { it.uppercase() }}",
                Toast.LENGTH_SHORT
            ).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        movesAdapter = null
        _binding = null
    }
}