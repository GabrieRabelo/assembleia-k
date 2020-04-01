package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Associate
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

interface AssociateService {
    fun createAssociate(assemblyId: String, associate: Associate) : Mono<Assembly>
}