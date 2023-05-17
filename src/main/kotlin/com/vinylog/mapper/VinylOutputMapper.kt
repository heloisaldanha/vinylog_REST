package com.vinylog.mapper

import com.vinylog.dto.VinylOutputDto
import com.vinylog.model.Vinyl
import org.springframework.stereotype.Component

@Component
class VinylOutputMapper: Mapper<Vinyl, VinylOutputDto> {

    override fun map(v: Vinyl): VinylOutputDto {
        return VinylOutputDto(
            id = v.id,
            artist = v.artist,
            album = v.album,
            country = v.country,
            releaseYear = v.releaseYear,
            recordCompany = v.recordCompany,
            color = v.color,
            size = v.vinylSize,
            cover = v.cover,
            type = v.vinylType
        )
    }
}