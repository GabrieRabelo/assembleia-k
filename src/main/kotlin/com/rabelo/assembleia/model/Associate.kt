package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Associate (@Id var id: String?,
                      val cpf: String,
                      val voto: String,
                      val topic: Topic)