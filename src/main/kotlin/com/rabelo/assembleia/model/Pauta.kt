package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Pauta(@Id var id: String?,
                 val descricao: String,
                 var associados: MutableList<Associado>?,
                 val assembleia: Assembleia)