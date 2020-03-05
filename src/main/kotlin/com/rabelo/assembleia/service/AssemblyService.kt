package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembly
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AssemblyService {
    fun createAssembly(): Mono<Assembly>
    fun getAssemblyList(): Flux<Assembly>
    fun getAssemblyById(id:String): Mono<Assembly>
    fun update(id:String, assembly:Assembly): Mono<Assembly>
    fun delete(id:String): Mono<Void>
}