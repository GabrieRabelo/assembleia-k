package com.rabelo.assembleia.repository

import com.rabelo.assembleia.model.Associado
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface AssociadoRepository : ReactiveCrudRepository<Associado, String> {
}