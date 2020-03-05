package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembly
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AssemblyService {
    fun create(): Mono<Assembly>
    fun getAssemblyList(): Flux<Assembly>
    fun getById(id:String): Mono<Assembly>
    fun update(id:String, assembly:Assembly): Mono<Assembly>
    fun deleteById(id:String): Mono<Void>
}