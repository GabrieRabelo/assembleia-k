package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Topic
import com.rabelo.assembleia.service.TopicServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux

@RestController
class TopicController @Autowired constructor(private val topicService: TopicServiceImpl) {

    @GetMapping(produces = ["application/stream+json"], value = ["/assembleia/{assemblyId}/pauta/"])
    fun getTopicList(@PathVariable assemblyId: String): Flux<Topic> {
        return topicService.getTopicList(assemblyId)
    }
}