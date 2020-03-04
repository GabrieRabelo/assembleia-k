package com.rabelo.assembleia.service

import com.rabelo.assembleia.exception.AssembleiaNotFoundException
import com.rabelo.assembleia.model.Assembleia
import com.rabelo.assembleia.repository.AssembleiaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class AssembleiaServiceImpl @Autowired constructor(private val repository: AssembleiaRepository) : AssembleiaService{

    override fun create(): Mono<Assembleia> {
        val assembleia = Assembleia(UUID.randomUUID().toString(), null)
        return repository.save(assembleia)
    }

    override fun getAssemblyList(): Flux<Assembleia> {
        return repository.findAll()
    }

    override fun getById(id:String): Mono<Assembleia> {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(AssembleiaNotFoundException))
    }

    override fun update(id:String, assembleia:Assembleia): Mono<Assembleia> {
        assembleia.id = id;
        return repository.save(assembleia)
    }

    override fun deleteById(id:String): Mono<Void> {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(AssembleiaNotFoundException))
                .flatMap { assembleia -> repository.delete(assembleia) }
                .then(Mono.empty())
    }
}