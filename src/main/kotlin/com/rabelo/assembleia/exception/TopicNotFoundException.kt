package com.rabelo.assembleia.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus
import java.lang.RuntimeException

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Tópico não encontrado!")
object TopicNotFoundException : RuntimeException()