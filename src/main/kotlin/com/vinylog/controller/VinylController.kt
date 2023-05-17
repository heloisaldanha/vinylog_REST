package com.vinylog.controller

import com.vinylog.dto.VinylInputDto
import com.vinylog.dto.VinylOutputDto
import com.vinylog.dto.VinylUpdateDto
import com.vinylog.model.Vinyl
import com.vinylog.service.VinylService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/")
class VinylController(
    private val service: VinylService
) {

    @GetMapping
    fun getVinylList(): List<VinylOutputDto> {
        return service.getVinylList()
    }

    @GetMapping("/vinil/{id}")
    fun getVinylById(@PathVariable id: Long): VinylOutputDto {
        return service.getById(id)
    }

    @PostMapping("/cadastrar-vinil")
    @Transactional
    fun create(@RequestBody @Valid vinyl: VinylInputDto,
                uriComponentsBuilder: UriComponentsBuilder
    ): ResponseEntity<VinylOutputDto> {
        val vinylOutputDto = service.create(vinyl)
        val uri = uriComponentsBuilder.path("/cadastrar-vinil/${vinylOutputDto.id}").build().toUri()
        return ResponseEntity.created(uri).body(vinylOutputDto)
    }

    @PutMapping("/editar-vinil")
    @Transactional
    fun update(@RequestBody @Valid vinyl: VinylUpdateDto): ResponseEntity<VinylOutputDto> {
        val vinylOutput = service.update(vinyl)
        return ResponseEntity.ok(vinylOutput)
    }

    @DeleteMapping("/{id}")
    @Transactional
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun delete(id: Long) {
        service.delete(id)
    }

}