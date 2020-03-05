package com.rabelo.assembleia.repository

import com.rabelo.assembleia.model.Assembly
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository

@Repository
interface AssembleiaRepository : ReactiveCrudRepository<Assembly, String>{
}