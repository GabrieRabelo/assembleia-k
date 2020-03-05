package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.service.AssemblyServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping(value = ["/assembleia"])
class AssemblyController @Autowired constructor(private val assembleiaService: AssemblyServiceImpl){

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    fun createAssembly(): Mono<Assembly> {
        return assembleiaService.create()
    }

    @GetMapping(produces = ["application/stream+json"])
    fun getList(): Flux<Assembly> {
        return assembleiaService.getAssemblyList()
    }

    @GetMapping(value = ["/{id}"])
    fun getById(@PathVariable id: String) : Mono<Assembly> {
        return assembleiaService.getById(id)
    }

    @PutMapping(value = ["/{id}"])
    fun updateAssembly(@PathVariable id:String, @RequestBody assembly: Assembly): Mono<Assembly> {
        return assembleiaService.update(id, assembly)
    }

    @DeleteMapping(value = ["/{id}"])
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    fun deleteAssembly(@PathVariable id: String) : Mono<Void> {
        return assembleiaService.deleteById(id)
    }
}