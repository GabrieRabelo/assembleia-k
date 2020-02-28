package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembleia
import com.rabelo.assembleia.repository.AssembleiaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping(value = ["/assembleia"])
class AssembleiaController @Autowired constructor(private val repository: AssembleiaRepository){

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun post(@RequestBody assembleia: Assembleia): Mono<Assembleia> {
        assembleia.id = UUID.randomUUID().toString()
        return repository.save(assembleia)
    }
}