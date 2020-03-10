package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Topic
import com.rabelo.assembleia.repository.AssemblyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.awt.List

@Service
class TopicServiceImpl @Autowired constructor(private val repository: AssemblyRepository): TopicService {

    override fun createTopic(assemblyId: String, topic: Topic): Mono<Assembly> {
        return repository.findById(assemblyId)
                .map { topicAdder(it, topic) }
                .flatMap { repository.save(it) }
    }

    fun topicAdder(assembly: Assembly, topic: Topic): Assembly {
        if(assembly.topics == null) {
            val topics = mutableListOf<Topic>()
            topics.add(topic)
            assembly.topics = topics
        } else {
            assembly.topics!!.add(topic)
        }
        return assembly
    }

    override fun getTopicList(assemblyId: String): Mono<MutableList<Topic>> {
        return repository.findById(assemblyId)
                .filter { checkTopic(it) }
                .map { it.topics }

//                .flatMapMany(Flux::fromIterable)
//                .switchIfEmpty(Mono.error(TopicNotFoundException))
    }


    fun checkTopic(assembly: Assembly): Boolean {
        return assembly.topics != null
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