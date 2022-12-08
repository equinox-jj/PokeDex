package com.pokedex.presentation.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.pokedex.R
import com.pokedex.databinding.FragmentHomeBinding
import com.pokedex.domain.utils.Resource
import com.pokedex.presentation.home.adapter.PokemonListAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val homeViewModel by viewModels<HomeViewModel>()

    /**
     * @see private lateinit homeAdapter: this is make memory
     * leak whenever navigate through fragment*/
//    private lateinit var homeAdapter: PokemonListAdapter
    private var homeAdapter: PokemonListAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentHomeBinding.bind(view)

        initObserver()
        initRecycler()
        setupListener()
    }

    private fun setupListener() {
        binding.refreshHome.setOnRefreshListener {
            homeViewModel.onRefresh()
            binding.refreshHome.isRefreshing = false
        }
        binding.fabPokemonHome.setOnClickListener {
            val action = HomeFragmentDirections.actionHomeFragmentToPokemonCatchFragment()
            it.findNavController().navigate(action)
        }
    }

    private fun initRecycler() {
        binding.rvHome.apply {
            homeAdapter = PokemonListAdapter()
            adapter = homeAdapter
            setHasFixedSize(true)
        }
    }

    private fun initObserver() {
        homeViewModel.state.observe(viewLifecycleOwner) { response ->
            when (response) {
                is Resource.Loading -> {
                    binding.pbHome.visibility = View.VISIBLE
                    binding.rvHome.visibility = View.GONE
                }
                is Resource.Success -> {
                    binding.pbHome.visibility = View.GONE
                    binding.rvHome.visibility = View.VISIBLE
                    response.data?.let { homeAdapter?.setData(it) }
                }
                is Resource.Error -> {
                    binding.pbHome.visibility = View.GONE
                    binding.rvHome.visibility = View.GONE
                    Snackbar.make(binding.root, getString(R.string.error_check_connection), Snackbar.LENGTH_INDEFINITE).show()
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        homeAdapter = null
        _binding = null
    }
}