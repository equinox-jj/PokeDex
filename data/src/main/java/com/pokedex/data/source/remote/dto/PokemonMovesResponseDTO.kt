package com.pokedex.data.source.remote.dto

import com.google.gson.annotations.SerializedName

data class PokemonMovesResponseDTO(

    @field:SerializedName("generation")
    val generation: GenerationMoveDTO? = null,

    @field:SerializedName("pp")
    val pp: Int? = null,

    @field:SerializedName("stat_changes")
    val statChanges: List<Any?>? = null,

    @field:SerializedName("accuracy")
    val accuracy: Int? = null,

    @field:SerializedName("contest_combos")
    val contestCombos: Any? = null,

    @field:SerializedName("priority")
    val priority: Int? = null,

    @field:SerializedName("super_contest_effect")
    val superContestEffect: SuperContestEffectDTO? = null,

    @field:SerializedName("type")
    val type: TypeMoveDTO? = null,

    @field:SerializedName("effect_changes")
    val effectChanges: List<Any?>? = null,

    @field:SerializedName("learned_by_pokemon")
    val learnedByPokemon: List<LearnedByPokemonItemDTO?>? = null,

    @field:SerializedName("target")
    val target: TargetDTO? = null,

    @field:SerializedName("effect_entries")
    val effectEntries: List<EffectEntriesItemDTO?>? = null,

    @field:SerializedName("contest_type")
    val contestType: ContestTypeDTO? = null,

    @field:SerializedName("past_values")
    val pastValues: List<PastValuesItemDTO?>? = null,

    @field:SerializedName("names")
    val names: List<NamesItemMovesDTO?>? = null,

    @field:SerializedName("meta")
    val meta: MetaDTO? = null,

    @field:SerializedName("flavor_text_entries")
    val flavorTextEntries: List<FlavorTextMovesDTO?>? = null,

    @field:SerializedName("damage_class")
    val damageClass: DamageClassDTO? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("effect_chance")
    val effectChance: Any? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("machines")
    val machines: List<MachinesItemDTO?>? = null,

    @field:SerializedName("power")
    val power: Int? = null,

    @field:SerializedName("contest_effect")
    val contestEffect: ContestEffectDTO? = null
)

data class AilmentDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class MovesVersionGroupDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class MachineDTO(

    @field:SerializedName("url")
    val url: String? = null
)

data class GenerationMoveDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class TargetDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class ContestEffectDTO(

    @field:SerializedName("url")
    val url: String? = null
)

data class DamageClassDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class SuperContestEffectDTO(

    @field:SerializedName("url")
    val url: String? = null
)

data class LearnedByPokemonItemDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class MetaDTO(

    @field:SerializedName("healing")
    val healing: Int? = null,

    @field:SerializedName("min_hits")
    val minHits: Any? = null,

    @field:SerializedName("max_hits")
    val maxHits: Any? = null,

    @field:SerializedName("ailment_chance")
    val ailmentChance: Int? = null,

    @field:SerializedName("crit_rate")
    val critRate: Int? = null,

    @field:SerializedName("flinch_chance")
    val flinchChance: Int? = null,

    @field:SerializedName("min_turns")
    val minTurns: Any? = null,

    @field:SerializedName("ailment")
    val ailment: AilmentDTO? = null,

    @field:SerializedName("category")
    val category: CategoryDTO? = null,

    @field:SerializedName("max_turns")
    val maxTurns: Any? = null,

    @field:SerializedName("drain")
    val drain: Int? = null,

    @field:SerializedName("stat_chance")
    val statChance: Int? = null
)

data class ContestTypeDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class CategoryDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class PastValuesItemDTO(

    @field:SerializedName("effect_entries")
    val effectEntries: List<Any?>? = null,

    @field:SerializedName("pp")
    val pp: Any? = null,

    @field:SerializedName("version_group")
    val versionGroup: MovesVersionGroupDTO? = null,

    @field:SerializedName("accuracy")
    val accuracy: Int? = null,

    @field:SerializedName("effect_chance")
    val effectChance: Any? = null,

    @field:SerializedName("power")
    val power: Any? = null,

    @field:SerializedName("type")
    val type: Any? = null
)

data class TypeMoveDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class MachinesItemDTO(

    @field:SerializedName("machine")
    val machine: MachineDTO? = null,

    @field:SerializedName("version_group")
    val versionGroup: MovesVersionGroupDTO? = null
)

data class LanguageMoveDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("url")
    val url: String? = null
)

data class NamesItemMovesDTO(

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("language")
    val language: LanguageMoveDTO? = null
)

data class EffectEntriesItemDTO(

    @field:SerializedName("short_effect")
    val shortEffect: String? = null,

    @field:SerializedName("effect")
    val effect: String? = null,

    @field:SerializedName("language")
    val language: LanguageMoveDTO? = null
)

data class FlavorTextMovesDTO(

    @field:SerializedName("version_group")
    val versionGroup: MovesVersionGroupDTO? = null,

    @field:SerializedName("language")
    val language: LanguageMoveDTO? = null,

    @field:SerializedName("flavor_text")
    val flavorText: String? = null
)
