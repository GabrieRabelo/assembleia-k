package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Topic(@Id var id: String?,
                 val description: String,
                 var associates: MutableList<Associate>?)