package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

data class Topic(val description: String,
                 var associates: MutableList<Associate>?)