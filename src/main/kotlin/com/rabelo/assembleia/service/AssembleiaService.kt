package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembleia
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AssembleiaService {
    fun create(): Mono<Assembleia>
    fun getAssemblyList(): Flux<Assembleia>
    fun getById(): Mono<Assembleia>
    fun update(): Mono<Assembleia>
    fun deleteById(): Mono<Void>
}