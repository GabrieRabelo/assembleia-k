package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Pauta
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface PautaService {
    fun create(): Mono<Pauta>
    fun getTopicList(): Flux<Pauta>
    fun getTopicById(id:String): Mono<Pauta>
    fun update(id:String, pauta: Pauta): Mono<Pauta>
    fun deleteById(id:String): Mono<Void>
}