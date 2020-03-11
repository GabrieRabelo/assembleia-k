package com.rabelo.assembleia.service

import com.rabelo.assembleia.exception.AssemblyNotFoundException
import com.rabelo.assembleia.exception.TopicNotFoundException
import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Topic
import com.rabelo.assembleia.repository.AssemblyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import java.awt.List
import java.util.*

@Service
class TopicServiceImpl @Autowired constructor(private val repository: AssemblyRepository): TopicService {

    override fun createTopic(assemblyId: String, topic: Topic): Mono<Assembly> {
        topic.id = UUID.randomUUID().toString()

        return repository.findById(assemblyId)
                .switchIfEmpty(Mono.error(AssemblyNotFoundException))
                .map { addTopic(it, topic) }
                .flatMap { repository.save(it) }
    }

    fun addTopic(assembly: Assembly, topic: Topic): Assembly {
        if(assembly.topics == null) {
            val topics = mutableListOf<Topic>()
            topics.add(topic)
            assembly.topics = topics
        } else {
            assembly.topics!!.add(topic)
        }
        return assembly
    }

    override fun getTopicList(assemblyId: String): Flux<Topic> {
        return repository.findById(assemblyId)
                .switchIfEmpty(Mono.error(AssemblyNotFoundException))
                .filter { it.topics != null }
                .switchIfEmpty(Mono.error(TopicNotFoundException))
                .flatMapMany{ it.topics!!.toFlux() }
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