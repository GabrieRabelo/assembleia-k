package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembleia
import com.rabelo.assembleia.repository.AssembleiaRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux

internal class AssembleiaControllerTest {

    lateinit var webTestClient: WebTestClient
    lateinit var assembleiaController: AssembleiaController
    lateinit var assembleiaRepository: AssembleiaRepository


    @BeforeEach
    fun setUp() {
        assembleiaRepository = Mockito.mock(AssembleiaRepository::class.java)
        assembleiaController = AssembleiaController(assembleiaRepository)
        webTestClient = WebTestClient.bindToController(assembleiaController).build()
    }

    @Test
    fun post() {
    }

    @Test
    fun `get will return a list`() {
        given(assembleiaRepository.findAll())
                .willReturn(Flux.just(Assembleia(null, null), Assembleia(null, null)))

        webTestClient.get()
                .uri("/assembleia")
                .exchange()
                .expectBodyList(Assembleia::class.java)
                .hasSize(2)
    }

    @Test
    fun getById() {
    }

    @Test
    fun put() {
    }

    @Test
    fun delete() {
    }
}