package com.rabelo.assembleia.model

data class Topic(var id: String?,
                 val description: String,
                 var associates: MutableList<Associate>?)