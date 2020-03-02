package com.rabelo.assembleia.controller

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
}