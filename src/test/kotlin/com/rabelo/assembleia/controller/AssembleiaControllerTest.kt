package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembleia
import com.rabelo.assembleia.repository.AssembleiaRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any

import org.mockito.BDDMockito.given
import org.mockito.BDDMockito.verify
import org.mockito.Mockito
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

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
    fun `post of assembly will return an valid assembly`() {
        given(assembleiaRepository.save(any(Assembleia::class.java)))
                .willReturn(Mono.just(Assembleia("1", null)))

        webTestClient.post()
                .uri("/assembleia")
                .exchange()
                .expectStatus().isCreated
                .expectBody(Assembleia::class.java)
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
    fun `get by id will return a single valid assembly`() {
        given(assembleiaRepository.findById("1"))
                .willReturn(Mono.just(Assembleia("1", null)))

        webTestClient.get()
                .uri("/assembleia/1")
                .exchange()
                .expectStatus().isOk
                .expectBody(Assembleia::class.java)
    }

    @Test
    fun put() {
    }

    @Test
    fun delete(){
    }
}