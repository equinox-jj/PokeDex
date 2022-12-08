package com.pokedex.data.mapper

import com.pokedex.data.source.remote.dto.*
import com.pokedex.domain.model.*

fun PokemonResponseDTO.responseDtoToDomain(): PokemonResponse {
    return PokemonResponse(
        count = count,
        result = results.map { it.resultDtoToDomain() }
    )
}

fun ResultsItemDTO.resultDtoToDomain(): PokemonResult {
    return PokemonResult(
        name = name,
        url = url,
    )
}

fun PokemonDetailResponseDTO.responseDetailDtoToDomain(): PokemonDetailResponse {
    return PokemonDetailResponse(
        id = id,
        sprites = sprites.spritesDtoToDomain(),
        name = name,
        baseExperience = baseExperience,
        height = height,
        weight = weight,
        moves = moves?.map { it.movesItemDtoToDomain() },
        types = types?.map { it.typesItemDtoToDomain() },
        stats = stats?.map { it.statsItemDtoToDomain() }
    )
}

fun SpritesDTO.spritesDtoToDomain(): SpritesPokemon {
    return SpritesPokemon(
        other = other?.otherDtoToDomain()
    )
}

fun OtherDTO.otherDtoToDomain(): OtherSprites {
    return OtherSprites(
        officialArtwork = officialArtwork?.offArtWorkDtoToDomain()
    )
}

fun OfficialArtworkDTO.offArtWorkDtoToDomain(): OfficialArtworkSprites {
    return OfficialArtworkSprites(
        frontDefault = frontDefault
    )
}

fun MovesItemDTO.movesItemDtoToDomain(): PokemonMoves {
    return PokemonMoves(
        move = move?.moveDtoToDomain(),
        versionGroupDetails = versionGroupDetails?.map { it.versionGroupDetailsDtoToDomain() }
    )
}

fun MoveDTO.moveDtoToDomain(): Moves {
    return Moves(
        name = name,
        url = url
    )
}

fun VersionGroupDetailsItemDTO.versionGroupDetailsDtoToDomain(): VersionGroupDetail {
    return VersionGroupDetail(
        levelLearnedAt = levelLearnedAt,
        moveLearnMethod = moveLearnMethod?.moveLearnDtoToDomain(),
        versionGroup = versionGroup?.moveLearnDtoToDomain()
    )
}

fun MoveLearnMethodDTO.moveLearnDtoToDomain(): MoveLearnMethod {
    return MoveLearnMethod(
        name = name,
        url = url
    )
}

fun VersionGroupDTO.moveLearnDtoToDomain(): VersionGroup {
    return VersionGroup(
        name = name,
        url = url
    )
}

fun TypesItemDTO.typesItemDtoToDomain(): PokemonTypes {
    return PokemonTypes(
        slot = slot,
        type = type?.typeDtoToDomain()
    )
}

fun TypeDTO.typeDtoToDomain(): TypePokemon {
    return TypePokemon(
        name = name,
        url = url
    )
}

fun StatsItemDTO.statsItemDtoToDomain(): PokemonStats {
    return PokemonStats(
        baseStat = baseStat,
        effort = effort,
        stat = stat?.statDtoToDomain(),
    )
}

fun StatDTO.statDtoToDomain(): StatsPokemon {
    return StatsPokemon(
        name = name,
        url = url
    )
}

fun PokemonSpeciesResponseDTO.speciesDtoToDOmain(): PokemonSpecies {
    return PokemonSpecies(
        flavorTextEntries = flavorTextEntries.map { it.flavorTextDtoToDomain() }
    )
}

fun FlavorTextEntriesItemDTO.flavorTextDtoToDomain(): FlavorTextEntries {
    return FlavorTextEntries(
        language = language?.languageDtoToDomain(),
        version = version?.versionDtoToDomain(),
        flavorText = flavorText
    )
}

fun LanguageDTO.languageDtoToDomain(): LanguageSpecies {
    return LanguageSpecies(
        name = name,
        url = url
    )
}

fun SpeciesVersionDTO.versionDtoToDomain(): VersionSpecies {
    return VersionSpecies(
        name = name,
        url = url
    )
}

fun PokemonMovesResponseDTO.moveResponseDtoToDomain(): PokemonMovesResult {
    return PokemonMovesResult(
        name = name,
        pp = pp,
        power = power,
        accuracy = accuracy,
        typed = type?.typeMoveDtoToDomain()
    )
}

fun TypeMoveDTO.typeMoveDtoToDomain(): PokemonMovesType {
    return PokemonMovesType(
        name = name
    )
}
