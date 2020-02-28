package com.rabelo.assembleia.repository

import com.rabelo.assembleia.model.Assembleia
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AssembleiaRepository : ReactiveCrudRepository<Assembleia, String>{
}