package com.rabelo.assembleia.service

import com.rabelo.assembleia.exception.AssemblyNotFoundException
import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.repository.AssembleiaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class AssemblyServiceImpl @Autowired constructor(private val repository: AssembleiaRepository) : AssemblyService{

    override fun createAssembly(): Mono<Assembly> {
        val assembleia = Assembly(UUID.randomUUID().toString(), null)
        return repository.save(assembleia)
    }

    override fun getAssemblyList(): Flux<Assembly> {
        return repository.findAll()
    }

    override fun getAssemblyById(id:String): Mono<Assembly> {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(AssemblyNotFoundException))
    }

    override fun update(id:String, assembly:Assembly): Mono<Assembly> {
        assembly.id = id;
        return repository.save(assembly)
    }

    override fun delete(id:String): Mono<Void> {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(AssemblyNotFoundException))
                .flatMap { assembleia -> repository.delete(assembleia) }
                .then(Mono.empty())
    }
}