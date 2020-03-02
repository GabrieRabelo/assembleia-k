package com.rabelo.assembleia.controller

import com.fasterxml.jackson.annotation.JsonFormat
import com.rabelo.assembleia.exception.AssembleiaNotFoundException
import com.rabelo.assembleia.model.Assembleia
import com.rabelo.assembleia.repository.AssembleiaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping(value = ["/assembleia"])
class AssembleiaController @Autowired constructor(private val repository: AssembleiaRepository){

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun post(): Mono<Assembleia> {
        val assembleia = Assembleia(UUID.randomUUID().toString(), null)
        return repository.save(assembleia)
    }

    @GetMapping(produces = ["application/stream+json"])
    fun get(): Flux<Assembleia> {
        return repository.findAll()
    }

    @PutMapping
    fun put(@RequestBody assembleia: Assembleia): Mono<Assembleia> {
        return repository.save(assembleia)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun delete(@PathVariable id: String) : Mono<Void> {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(AssembleiaNotFoundException))
                .flatMap { assembleia -> repository.delete(assembleia) }
                .then(Mono.empty())
    }
}