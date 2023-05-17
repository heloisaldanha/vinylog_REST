package com.vinylog.model

import com.vinylog.enums.Cover
import com.vinylog.enums.VinylSize
import com.vinylog.enums.VinylType
import jakarta.persistence.Entity
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne

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

    @Enumerated
    var vinylSize: VinylSize = VinylSize.TEN,

    @Enumerated
    var cover: Cover = Cover.SIMPLE,

    @Enumerated
    var vinylType: VinylType = VinylType.SIMPLE,

    @ManyToOne
    val userClient: UserClient
)
