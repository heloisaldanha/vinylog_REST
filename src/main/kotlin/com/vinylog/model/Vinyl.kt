package com.vinylog.model

import com.vinylog.enums.Cover
import com.vinylog.enums.VinylSize
import com.vinylog.enums.VinylType
import jakarta.persistence.*

@Entity
data class Vinyl(

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var artist: String,
    var album: String,
    var country: String,
    var releaseYear: String,
    var recordCompany: String,
    var color: String,

    @Enumerated(value = EnumType.STRING)
    var vinylSize: VinylSize = VinylSize.TEN,

    @Enumerated(value = EnumType.STRING)
    var cover: Cover = Cover.SIMPLE,

    @Enumerated(value = EnumType.STRING)
    var vinylType: VinylType = VinylType.SIMPLE,

    @ManyToOne
    val userClient: UserClient
)
