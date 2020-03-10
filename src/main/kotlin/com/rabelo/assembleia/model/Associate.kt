package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class Associate (val cpf: String,
                      val vote: String)