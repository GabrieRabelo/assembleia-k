package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Topic
import com.rabelo.assembleia.service.TopicServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux

@RestController
class TopicController @Autowired constructor(private val topicService: TopicServiceImpl) {

    @PostMapping(value = ["/assembleia/{assemblyId}/pauta"])
    fun createTopic(@PathVariable assemblyId: String, @RequestBody topic: Topic) {
        topicService.createTopic(assemblyId, topic)
    }

    @GetMapping(produces = ["application/stream+json"], value = ["/assembleia/{assemblyId}/pauta"])
    fun getTopicList(@PathVariable assemblyId: String): Flux<Topic> {
        return topicService.getTopicList(assemblyId)
    }
}