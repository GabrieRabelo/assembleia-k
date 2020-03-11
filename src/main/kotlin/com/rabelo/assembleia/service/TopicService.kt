package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Topic
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface TopicService {
    fun createTopic(assemblyId: String, topic: Topic): Mono<Assembly>
    fun getTopicList(assemblyId: String): Flux<Topic>
    fun getTopicById(id:String): Mono<Topic>
    fun update(id:String, topic: Topic): Mono<Topic>
    fun deleteById(id:String): Mono<Void>
}