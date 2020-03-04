package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembleia
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface AssembleiaService {
    fun create(): Mono<Assembleia>
    fun getAssemblyList(): Flux<Assembleia>
    fun getById(id:String): Mono<Assembleia>
    fun update(id:String, assembleia:Assembleia): Mono<Assembleia>
    fun deleteById(id:String): Mono<Void>
}