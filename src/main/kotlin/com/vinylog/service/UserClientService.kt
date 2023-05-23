package com.vinylog.service

import com.vinylog.model.UserClient
import com.vinylog.repository.UserClientRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserClientService(
    private val repository: UserClientRepository
): UserDetailsService {

    fun getById(id: Long): UserClient {
        return repository.getReferenceById(id)
    }

    override fun loadUserByUsername(username: String?): UserDetails {
        val user = repository.findByEmail(username) ?: throw RuntimeException()
        return UserDetail(user)
    }
}