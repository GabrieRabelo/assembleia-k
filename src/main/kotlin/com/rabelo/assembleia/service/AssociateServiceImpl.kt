package com.rabelo.assembleia.service

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.model.Associate
import com.rabelo.assembleia.repository.AssemblyRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class AssociateServiceImpl @Autowired constructor(private val assemblyRepository: AssemblyRepository): AssociateService {
    override fun createAssociate(assemblyId: String, associate: Associate): Mono<Assembly> {
        return assemblyRepository.findById(assemblyId)
    }
}