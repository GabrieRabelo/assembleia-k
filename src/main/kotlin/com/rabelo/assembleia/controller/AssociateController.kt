package com.rabelo.assembleia.controller

import com.rabelo.assembleia.exception.TopicNotFoundException
import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Associate
import com.rabelo.assembleia.service.AssociateService
import com.rabelo.assembleia.service.AssociateServiceImpl
import com.rabelo.assembleia.service.TopicServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
class AssociateController @Autowired constructor(private val associateService: AssociateServiceImpl,
                                                 private val topicService: TopicServiceImpl){

//    @PutMapping
//    fun createAssociate(assemblyId: String, topicId: String, associate: Associate): Mono<Assembly> {
//        topicService.getTopicList(assemblyId)
//                .switchIfEmpty(Mono.error(TopicNotFoundException))
//                .
//    }
}