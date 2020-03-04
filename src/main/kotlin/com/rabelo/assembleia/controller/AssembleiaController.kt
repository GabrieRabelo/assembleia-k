package com.rabelo.assembleia.controller

import com.rabelo.assembleia.exception.AssembleiaNotFoundException
import com.rabelo.assembleia.model.Assembleia
import com.rabelo.assembleia.repository.AssembleiaRepository
import com.rabelo.assembleia.service.AssembleiaServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@RestController
@RequestMapping(value = ["/assembleia"])
class AssembleiaController @Autowired constructor(private val assembleiaService: AssembleiaServiceImpl){

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createAssembly(): Mono<Assembleia> {
        return assembleiaService.create()
    }

    @GetMapping(produces = ["application/stream+json"])
    fun getList(): Flux<Assembleia> {
        return assembleiaService.getAssemblyList()
    }

    @GetMapping(value = ["/{id}"])
    fun getById(@PathVariable id: String) : Mono<Assembleia> {
        return assembleiaService.getById(id)
    }

    @PutMapping(value = ["/{id}"])
    fun updateAssembly(@PathVariable id:String, @RequestBody assembleia: Assembleia): Mono<Assembleia> {
        return assembleiaService.update(id, assembleia)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteAssembly(@PathVariable id: String) : Mono<Void> {
        return assembleiaService.deleteById(id)
    }
}