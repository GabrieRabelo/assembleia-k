package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Pauta(@Id var id: String?,
                 val descricao: String,
                 val associados: MutableCollection<Associado>,
                 val assembleia: Assembleia) {
}