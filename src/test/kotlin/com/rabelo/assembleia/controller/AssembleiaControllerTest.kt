package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembleia
import com.rabelo.assembleia.repository.AssembleiaRepository
import com.rabelo.assembleia.service.AssembleiaServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.ArgumentMatchers.any
import org.mockito.ArgumentMatchers.anyInt

import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

internal class AssembleiaControllerTest {

    lateinit var webTestClient: WebTestClient
    lateinit var assembleiaController: AssembleiaController
    lateinit var assembleiaService: AssembleiaServiceImpl


    @BeforeEach
    fun setUp() {
        assembleiaService = Mockito.mock(AssembleiaServiceImpl::class.java)
        assembleiaController = AssembleiaController(assembleiaService)
        webTestClient = WebTestClient.bindToController(assembleiaController).build()
    }

    @Test
    fun `post of assembly will return an valid assembly`() {
        given(assembleiaService.create())
                .willReturn(Mono.just(Assembleia("1", null)))

        webTestClient.post()
                .uri("/assembleia")
                .exchange()
                .expectStatus().isCreated
                .expectBody(Assembleia::class.java)
    }

    @Test
    fun `get will return a list`() {
        given(assembleiaService.getAssemblyList())
                .willReturn(Flux.just(Assembleia(null, null), Assembleia(null, null)))

        webTestClient.get()
                .uri("/assembleia")
                .exchange()
                .expectBodyList(Assembleia::class.java)
                .hasSize(2)
    }

    @Test
    fun `get by id will return a single valid assembly`() {
        given(assembleiaService.getById("1"))
                .willReturn(Mono.just(Assembleia("1", null)))

        webTestClient.get()
                .uri("/assembleia/1")
                .exchange()
                .expectStatus().isOk
                .expectBody(Assembleia::class.java)
    }

    @Test
    fun `put will update an assembly and return it`() {
        val assembly = Assembleia("5", null)

        given(assembleiaService.update("2", assembly))
                .willReturn(Mono.just(assembly))

        val assemblyMono = Mono.just(assembly)

        webTestClient.put()
                .uri("/assembleia/1")
                .body(assemblyMono, Assembleia::class.java)
                .exchange()
                .expectStatus().isOk
                .expectBody(Assembleia::class.java)
    }

    @Test
    fun delete(){
        given(assembleiaService.getById("1"))
                .willReturn(Mono.just(Assembleia("1", null)))

        given(assembleiaService.deleteById("1"))
                .willReturn(Mono.empty())

        webTestClient.delete()
                .uri("/assembleia/1")
                .exchange()
                .expectStatus().isNoContent
    }
}