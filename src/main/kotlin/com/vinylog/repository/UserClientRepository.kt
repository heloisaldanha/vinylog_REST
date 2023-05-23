package com.vinylog.repository

import com.vinylog.model.UserClient
import org.springframework.data.jpa.repository.JpaRepository

interface UserClientRepository: JpaRepository<UserClient, Long> {

    fun findByEmail(username: String?): UserClient?
}