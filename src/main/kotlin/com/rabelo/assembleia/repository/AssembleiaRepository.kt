package com.rabelo.assembleia.repository

import com.rabelo.assembleia.model.Assembleia
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AssembleiaRepository : ReactiveCrudRepository<Assembleia, String>{
}