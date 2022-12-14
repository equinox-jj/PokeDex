package com.pokedex.presentation.mypokemon

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.pokedex.R
import com.pokedex.databinding.FragmentPokemonCatchBinding
import com.pokedex.presentation.mypokemon.adapter.PokemonCatchAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PokemonCatchFragment : Fragment(R.layout.fragment_pokemon_catch) {

    private var _binding: FragmentPokemonCatchBinding? = null
    private val binding get() = _binding!!

    private var pokemonCatchAdapter: PokemonCatchAdapter? = null
    private val pokemonCatchViewModel by viewModels<PokemonCatchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentPokemonCatchBinding.bind(view)

        initRecycler()
        initObserver()
        setupListener()
    }

    private fun setupListener() {
        binding.fabPokemonCatch.setOnClickListener {
            alertDialog()
        }
        binding.ivPokemonCatchBack.setOnClickListener {
            it.findNavController().popBackStack()
        }
    }

    private fun initObserver() {
        pokemonCatchViewModel.getPokemonCatched.observe(viewLifecycleOwner) { entity ->
            if (entity.isNotEmpty()) {
                checkPokemonCatched(true)
                pokemonCatchAdapter?.setData(entity)
            } else {
                checkPokemonCatched(false)
            }
        }
    }

    private fun checkPokemonCatched(isPokemonCatched: Boolean) {
        if (isPokemonCatched) {
            binding.rvPokemonCatch.visibility = View.VISIBLE
            binding.lottieNoData.visibility = View.GONE
            binding.tvPokemonNoData.visibility = View.GONE
        } else {
            binding.rvPokemonCatch.visibility = View.GONE
            binding.lottieNoData.visibility = View.VISIBLE
            binding.tvPokemonNoData.visibility = View.VISIBLE
        }
    }

    private fun initRecycler() {
        binding.rvPokemonCatch.apply {
            pokemonCatchAdapter = PokemonCatchAdapter()
            adapter = pokemonCatchAdapter
            setHasFixedSize(true)
        }
    }

    private fun alertDialog() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Remove All Pokemon")
        builder.setMessage("Are you sure you want to remove all pokemon?")
        builder.setPositiveButton("Yes") { _, _ ->
            pokemonCatchViewModel.removeAllPokemon()
            Toast.makeText(requireContext(), "Successfully remove all pokemon", Toast.LENGTH_SHORT).show()
        }
        builder.setNegativeButton("No") { _, _ -> }
        builder.create().show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        pokemonCatchAdapter = null
        _binding = null
    }
}