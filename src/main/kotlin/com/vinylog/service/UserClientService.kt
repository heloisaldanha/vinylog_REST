package com.vinylog.service

import com.vinylog.model.UserClient
import com.vinylog.repository.UserClientRepository
import org.springframework.stereotype.Service

@Service
class UserClientService(
    private val repository: UserClientRepository
) {

    fun getById(id: Long): UserClient {
        return repository.getReferenceById(id)
    }
}