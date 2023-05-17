package com.vinylog.dto

import java.time.LocalDateTime

data class ErrorOutputDto(
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val status: Int,
    val error: String,
    val message: String?,
    val path: String
)