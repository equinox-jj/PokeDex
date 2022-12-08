package com.pokedex.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonDetailResponseDTO(

	@field:SerializedName("location_area_encounters")
	val locationAreaEncounters: String? = null,

	@field:SerializedName("types")
	val types: List<TypesItemDTO>? = null,

	@field:SerializedName("base_experience")
	val baseExperience: Int? = null,

	@field:SerializedName("held_items")
	val heldItems: List<Any>? = null,

	@field:SerializedName("weight")
	val weight: Int? = null,

	@field:SerializedName("is_default")
	val isDefault: Boolean? = null,

	@field:SerializedName("past_types")
	val pastTypes: List<Any>? = null,

	@field:SerializedName("sprites")
	val sprites: SpritesDTO,

	@field:SerializedName("abilities")
	val abilities: List<AbilitiesItemDTO>? = null,

	@field:SerializedName("game_indices")
	val gameIndices: List<GameIndicesItemDTO>? = null,

	@field:SerializedName("species")
	val species: SpeciesDTO? = null,

	@field:SerializedName("stats")
	val stats: List<StatsItemDTO>? = null,

	@field:SerializedName("moves")
	val moves: List<MovesItemDTO>? = null,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: Int,

	@field:SerializedName("forms")
	val forms: List<FormsItemDTO>? = null,

	@field:SerializedName("height")
	val height: Int? = null,

	@field:SerializedName("order")
	val order: Int? = null
)

data class VersionDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class GenerationIiiDTO(

	@field:SerializedName("firered-leafgreen")
	val fireredLeafgreen: FireredLeafgreenDTO? = null,

	@field:SerializedName("ruby-sapphire")
	val rubySapphire: RubySapphireDTO? = null,

	@field:SerializedName("emerald")
	val emerald: EmeraldDTO? = null
)

data class GenerationViiDTO(

	@field:SerializedName("icons")
	val icons: IconsDTO? = null,

	@field:SerializedName("ultra-sun-ultra-moon")
	val ultraSunUltraMoon: UltraSunUltraMoonDTO? = null
)

data class AbilitiesItemDTO(

	@field:SerializedName("is_hidden")
	val isHidden: Boolean? = null,

	@field:SerializedName("ability")
	val ability: AbilityDTO? = null,

	@field:SerializedName("slot")
	val slot: Int? = null
)

data class FireredLeafgreenDTO(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class GameIndicesItemDTO(

	@field:SerializedName("game_index")
	val gameIndex: Int? = null,

	@field:SerializedName("version")
	val version: VersionDTO? = null
)

data class TypeDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class PlatinumDTO(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class MovesItemDTO(

	@field:SerializedName("version_group_details")
	val versionGroupDetails: List<VersionGroupDetailsItemDTO>? = null,

	@field:SerializedName("move")
	val move: MoveDTO? = null
)

data class GoldDTO(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_transparent")
	val frontTransparent: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class GenerationViDTO(

	@field:SerializedName("omegaruby-alphasapphire")
	val omegarubyAlphasapphire: OmegarubyAlphasapphireDTO? = null,

	@field:SerializedName("x-y")
	val xY: XYDTO? = null
)

data class DiamondPearlDTO(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class TypesItemDTO(

	@field:SerializedName("slot")
	val slot: Int? = null,

	@field:SerializedName("type")
	val type: TypeDTO? = null
)

data class HomeDTO(

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class GenerationIDTO(

	@field:SerializedName("yellow")
	val yellow: YellowDTO? = null,

	@field:SerializedName("red-blue")
	val redBlue: RedBlueDTO? = null
)

data class VersionsDTO(

	@field:SerializedName("generation-iii")
	val generationIii: GenerationIiiDTO? = null,

	@field:SerializedName("generation-ii")
	val generationIi: GenerationIiDTO? = null,

	@field:SerializedName("generation-v")
	val generationV: GenerationVDTO? = null,

	@field:SerializedName("generation-iv")
	val generationIv: GenerationIvDTO? = null,

	@field:SerializedName("generation-vii")
	val generationVii: GenerationViiDTO? = null,

	@field:SerializedName("generation-i")
	val generationI: GenerationIDTO? = null,

	@field:SerializedName("generation-viii")
	val generationViii: GenerationViiiDTO? = null,

	@field:SerializedName("generation-vi")
	val generationVi: GenerationViDTO? = null
)

data class FormsItemDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class RedBlueDTO(

	@field:SerializedName("front_gray")
	val frontGray: String? = null,

	@field:SerializedName("back_transparent")
	val backTransparent: String? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("back_gray")
	val backGray: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_transparent")
	val frontTransparent: String? = null
)

data class XYDTO(

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class OfficialArtworkDTO(

	@field:SerializedName("front_default")
	val frontDefault: String? = null
)

data class VersionGroupDetailsItemDTO(

	@field:SerializedName("level_learned_at")
	val levelLearnedAt: Int? = null,

	@field:SerializedName("version_group")
	val versionGroup: VersionGroupDTO? = null,

	@field:SerializedName("move_learn_method")
	val moveLearnMethod: MoveLearnMethodDTO? = null
)

data class StatsItemDTO(

	@field:SerializedName("stat")
	val stat: StatDTO? = null,

	@field:SerializedName("base_stat")
	val baseStat: Int? = null,

	@field:SerializedName("effort")
	val effort: Int? = null
)

data class EmeraldDTO(

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class DreamWorldDTO(

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null
)

data class SilverDTO(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_transparent")
	val frontTransparent: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class SpeciesDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class MoveLearnMethodDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class OtherDTO(

	@field:SerializedName("dream_world")
	val dreamWorld: DreamWorldDTO? = null,

	@field:SerializedName("official-artwork")
	val officialArtwork: OfficialArtworkDTO? = null,

	@field:SerializedName("home")
	val home: HomeDTO? = null
)

data class AnimatedDTO(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class GenerationIvDTO(

	@field:SerializedName("platinum")
	val platinum: PlatinumDTO? = null,

	@field:SerializedName("diamond-pearl")
	val diamondPearl: DiamondPearlDTO? = null,

	@field:SerializedName("heartgold-soulsilver")
	val heartgoldSoulsilver: HeartgoldSoulsilverDTO? = null
)

data class RubySapphireDTO(

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class BlackWhiteDTO(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("animated")
	val animated: AnimatedDTO? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class GenerationViiiDTO(

	@field:SerializedName("icons")
	val icons: IconsDTO? = null
)

data class GenerationIiDTO(

	@field:SerializedName("gold")
	val gold: GoldDTO? = null,

	@field:SerializedName("crystal")
	val crystal: CrystalDTO? = null,

	@field:SerializedName("silver")
	val silver: SilverDTO? = null
)

data class GenerationVDTO(

	@field:SerializedName("black-white")
	val blackWhite: BlackWhiteDTO? = null
)

data class YellowDTO(

	@field:SerializedName("front_gray")
	val frontGray: String? = null,

	@field:SerializedName("back_transparent")
	val backTransparent: String? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("back_gray")
	val backGray: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_transparent")
	val frontTransparent: String? = null
)

data class MoveDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class HeartgoldSoulsilverDTO(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class IconsDTO(

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null
)

data class CrystalDTO(

	@field:SerializedName("back_transparent")
	val backTransparent: String? = null,

	@field:SerializedName("back_shiny_transparent")
	val backShinyTransparent: String? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_transparent")
	val frontTransparent: String? = null,

	@field:SerializedName("front_shiny_transparent")
	val frontShinyTransparent: String? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class UltraSunUltraMoonDTO(

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class OmegarubyAlphasapphireDTO(

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class AbilityDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class StatDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)

data class SpritesDTO(

	@field:SerializedName("back_shiny_female")
	val backShinyFemale: Any? = null,

	@field:SerializedName("back_female")
	val backFemale: Any? = null,

	@field:SerializedName("other")
	val other: OtherDTO? = null,

	@field:SerializedName("back_default")
	val backDefault: String? = null,

	@field:SerializedName("front_shiny_female")
	val frontShinyFemale: Any? = null,

	@field:SerializedName("front_default")
	val frontDefault: String? = null,

	@field:SerializedName("versions")
	val versions: VersionsDTO? = null,

	@field:SerializedName("front_female")
	val frontFemale: Any? = null,

	@field:SerializedName("back_shiny")
	val backShiny: String? = null,

	@field:SerializedName("front_shiny")
	val frontShiny: String? = null
)

data class VersionGroupDTO(

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)
