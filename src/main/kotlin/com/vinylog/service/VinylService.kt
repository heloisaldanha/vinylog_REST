package com.vinylog.service

import com.vinylog.dto.VinylInputDto
import com.vinylog.dto.VinylOutputDto
import com.vinylog.dto.VinylUpdateDto
import com.vinylog.mapper.VinylMapper
import com.vinylog.mapper.VinylOutputMapper
import com.vinylog.model.Vinyl
import com.vinylog.repository.VinylRepository
import exception.NotFoundException
import org.springframework.stereotype.Service
import java.util.stream.Collectors


@Service
class VinylService(
    private val repository: VinylRepository,
    private val vinylOutputMapper: VinylOutputMapper,
    private val vinylMapper: VinylMapper
) {

    fun getVinylList(): List<VinylOutputDto> {
        println("Mostrando lista de vinis")
        return repository.findAll().stream().map { v -> vinylOutputMapper.map(v) }.collect(Collectors.toList())
    }

    fun getById(id: Long): VinylOutputDto {
        println("Buscando por ID")
        val vinyl = repository.findById(id).orElseThrow {
            NotFoundException("Vinil não encontrado")
        }
        return vinylOutputMapper.map(vinyl)
    }

    fun create(vinylInput: VinylInputDto): VinylOutputDto {
        println("Iniciando o cadastro de um novo vinil")
        val vinyl = vinylMapper.map(vinylInput)
        repository.save(vinyl)
        return vinylOutputMapper.map(vinyl)
    }

    fun update(update: VinylUpdateDto): VinylOutputDto {
        println("Atualizando um vinil")
        val vinyl = repository.findById(update.id).orElseThrow {
            NotFoundException("Vinil não encontrado")
        }
        vinyl.artist = update.artist
        vinyl.album = update.album
        vinyl.country = update.country
        vinyl.releaseYear = update.releaseYear
        vinyl.recordCompany = update.recordCompany
        vinyl.color = update.color
        vinyl.vinylSize = update.size
        vinyl.cover = update.cover
        vinyl.vinylType = update.type

        return vinylOutputMapper.map(vinyl)
    }

    fun delete(id: Long) {
        println("Deletando um vinil")
        repository.deleteById(id)
    }

}