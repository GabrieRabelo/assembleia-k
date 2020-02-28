package com.rabelo.assembleia

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document
data class Voto (@Id var id: String?,
                 val voto: String){
}