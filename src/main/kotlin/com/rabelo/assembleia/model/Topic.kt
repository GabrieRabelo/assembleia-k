package com.rabelo.assembleia.model

import org.springframework.data.annotation.Id

data class Topic(@Id var id: String?,
                 val description: String,
                 var associates: MutableList<Associate>?)