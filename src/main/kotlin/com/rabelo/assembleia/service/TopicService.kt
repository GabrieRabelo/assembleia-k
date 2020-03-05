package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Topic
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TopicService {
    fun create(): Mono<Topic>
    fun getTopicList(): Flux<Topic>
    fun getTopicById(id:String): Mono<Topic>
    fun update(id:String, pauta: Topic): Mono<Topic>
    fun deleteById(id:String): Mono<Void>
}