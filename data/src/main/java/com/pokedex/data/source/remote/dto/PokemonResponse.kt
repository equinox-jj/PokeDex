package com.pokedex.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonResponseDTO(

	@field:SerializedName("next")
	val next: String? = null,

	@field:SerializedName("previous")
	val previous: Any? = null,

	@field:SerializedName("count")
	val count: Int? = null,

	@field:SerializedName("results")
	val results: List<ResultsItemDTO>
)

data class ResultsItemDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
