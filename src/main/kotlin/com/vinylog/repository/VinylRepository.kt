package com.vinylog.repository

import com.vinylog.model.Vinyl
import org.springframework.data.jpa.repository.JpaRepository

interface VinylRepository: JpaRepository<Vinyl, Long> {
}