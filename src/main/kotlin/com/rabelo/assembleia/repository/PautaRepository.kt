package com.rabelo.assembleia.repository

import com.rabelo.assembleia.model.Pauta
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface PautaRepository: ReactiveCrudRepository<Pauta, String> {
}