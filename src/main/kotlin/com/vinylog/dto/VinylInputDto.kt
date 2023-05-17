package com.vinylog.dto

import com.vinylog.enums.Cover
import com.vinylog.enums.VinylSize
import com.vinylog.enums.VinylType
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull

data class VinylInputDto(

    @field:NotEmpty
    val artist: String,

    @field:NotEmpty
    val album: String,
    val country: String,
    val releaseYear: String,
    val recordCompany: String,
    val color: String,
    val size: VinylSize,
    val cover: Cover,
    val type: VinylType,

    @field:NotNull
    val idUser: Long
)
