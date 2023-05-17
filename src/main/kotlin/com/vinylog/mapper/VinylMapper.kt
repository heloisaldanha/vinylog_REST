package com.vinylog.mapper

import com.vinylog.dto.VinylInputDto
import com.vinylog.model.Vinyl
import com.vinylog.service.UserClientService
import com.vinylog.service.VinylService
import org.springframework.stereotype.Component

@Component
class VinylMapper(private val userClientService: UserClientService): Mapper<VinylInputDto, Vinyl> {

    override fun map(v: VinylInputDto): Vinyl {
        return Vinyl(
            artist = v.artist,
            album = v.album,
            country = v.country,
            releaseYear = v.releaseYear,
            recordCompany = v.recordCompany,
            color = v.color,
            vinylType = v.type,
            cover = v.cover,
            vinylSize = v.size,
            userClient = userClientService.getById(v.idUser)
        )
    }
}