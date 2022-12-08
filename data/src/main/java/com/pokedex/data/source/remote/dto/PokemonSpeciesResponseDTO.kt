package com.pokedex.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonSpeciesResponseDTO(

    @field:SerializedName("evolution_chain")
    val evolutionChain: EvolutionChainDTO? = null,

    @field:SerializedName("genera")
    val genera: List<GeneraItemDTO?>? = null,

    @field:SerializedName("habitat")
    val habitat: HabitatDTO? = null,

    @field:SerializedName("color")
    val color: ColorDTO? = null,

    @field:SerializedName("egg_groups")
    val eggGroups: List<EggGroupsItemDTO?>? = null,

    @field:SerializedName("capture_rate")
    val captureRate: Int? = null,

    @field:SerializedName("pokedex_numbers")
    val pokedexNumbers: List<PokedexNumbersItemDTO?>? = null,

    @field:SerializedName("forms_switchable")
    val formsSwitchable: Boolean? = null,

    @field:SerializedName("growth_rate")
    val growthRate: GrowthRateDTO? = null,

    @field:SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextEntriesItemDTO>,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("is_baby")
    val isBaby: Boolean? = null,

    @field:SerializedName("order")
    val order: Int? = null,

    @field:SerializedName("generation")
    val generation: GenerationDTO? = null,

    @field:SerializedName("is_legendary")
    val isLegendary: Boolean? = null,

    @field:SerializedName("pal_park_encounters")
    val palParkEncounters: List<PalParkEncountersItemDTO?>? = null,

    @field:SerializedName("shape")
    val shape: ShapeDTO? = null,

    @field:SerializedName("is_mythical")
    val isMythical: Boolean? = null,

    @field:SerializedName("base_happiness")
    val baseHappiness: Int? = null,

    @field:SerializedName("names")
    val names: List<NamesItemDTO?>? = null,

    @field:SerializedName("varieties")
    val varieties: List<VarietiesItemDTO?>? = null,

    @field:SerializedName("gender_rate")
    val genderRate: Int? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("has_gender_differences")
    val hasGenderDifferences: Boolean? = null,

    @field:SerializedName("hatch_counter")
    val hatchCounter: Int? = null,

    @field:SerializedName("form_descriptions")
    val formDescriptions: List<Any?>? = null,

    @field:SerializedName("evolves_from_species")
    val evolvesFromSpecies: Any? = null
)

data class ShapeDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class PokedexDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class VarietiesItemDTO(

    @field:SerializedName("pokemon")
    val pokemon: PokemonDTO? = null,

    @field:SerializedName("is_default")
    val isDefault: Boolean? = null
)

data class ColorDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class FlavorTextEntriesItemDTO(

    @field:SerializedName("language")
    val language: LanguageDTO? = null,

    @field:SerializedName("version")
    val version: SpeciesVersionDTO? = null,

    @field:SerializedName("flavor_text")
    val flavorText: String? = null
)

data class PalParkEncountersItemDTO(

    @field:SerializedName("area")
    val area: AreaDTO? = null,

    @field:SerializedName("base_score")
    val baseScore: Int? = null,

    @field:SerializedName("rate")
    val rate: Int? = null
)

data class NamesItemDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("language")
    val language: LanguageDTO? = null
)

data class PokedexNumbersItemDTO(

    @field:SerializedName("entry_number")
    val entryNumber: Int? = null,

    @field:SerializedName("pokedex")
    val pokedex: PokedexDTO? = null
)

data class AreaDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class PokemonDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class HabitatDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class EvolutionChainDTO(

    @field:SerializedName("url")
    val url: String? = null
)

data class LanguageDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class GenerationDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class GeneraItemDTO(

    @field:SerializedName("genus")
    val genus: String? = null,

    @field:SerializedName("language")
    val language: LanguageDTO? = null
)

data class EggGroupsItemDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class SpeciesVersionDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class GrowthRateDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)
