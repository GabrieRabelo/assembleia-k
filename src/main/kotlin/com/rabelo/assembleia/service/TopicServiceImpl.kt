package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Topic
import com.rabelo.assembleia.repository.AssemblyRepository
import org.springframework.beans.factory.annotation.Autowired
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

class TopicServiceImpl @Autowired constructor(private val repository: AssemblyRepository): TopicService {



    override fun createTopic(assemblyId: String, topic: Topic): Mono<Topic> {
        TODO("Not yet implemented")
    }

    override fun getTopicList(): Flux<Topic> {
        TODO("Not yet implemented")
    }

    override fun getTopicById(id: String): Mono<Topic> {
        TODO("Not yet implemented")
    }

    override fun update(id: String, topic: Topic): Mono<Topic> {
        TODO("Not yet implemented")
    }

    override fun deleteById(id: String): Mono<Void> {
        TODO("Not yet implemented")
    }
}