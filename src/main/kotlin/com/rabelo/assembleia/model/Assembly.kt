package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Assembly(@Id var id: String?,
                    var topics: MutableList<Topic>?)