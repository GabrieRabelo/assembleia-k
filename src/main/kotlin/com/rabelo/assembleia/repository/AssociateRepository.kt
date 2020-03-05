package com.rabelo.assembleia.repository

import com.rabelo.assembleia.model.Associate
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AssociateRepository : ReactiveCrudRepository<Associate, String> {
}