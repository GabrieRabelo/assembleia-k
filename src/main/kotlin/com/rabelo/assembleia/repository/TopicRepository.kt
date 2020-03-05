package com.rabelo.assembleia.repository

import com.rabelo.assembleia.model.Topic
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface TopicRepository: ReactiveCrudRepository<Topic, String> {
}