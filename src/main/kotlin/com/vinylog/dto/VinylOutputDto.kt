package com.vinylog.dto

import com.vinylog.enums.Cover
import com.vinylog.enums.VinylSize
import com.vinylog.enums.VinylType

data class VinylOutputDto(
    val id: Long? = null,
    val artist: String,
    val album: String,
    val country: String,
    val releaseYear: String,
    val recordCompany: String,
    val color: String,
    val size: VinylSize,
    val cover: Cover,
    val type: VinylType
)
