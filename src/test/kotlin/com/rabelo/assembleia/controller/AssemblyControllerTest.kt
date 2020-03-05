package com.rabelo.assembleia.controller

import com.rabelo.assembleia.model.Assembly
import com.rabelo.assembleia.service.AssemblyServiceImpl
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import org.mockito.BDDMockito.given
import org.mockito.Mockito
import org.springframework.test.web.reactive.server.WebTestClient
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

internal class AssemblyControllerTest {

    lateinit var webTestClient: WebTestClient
    lateinit var assemblyController: AssemblyController
    lateinit var assembleiaService: AssemblyServiceImpl


    @BeforeEach
    fun setUp() {
        assembleiaService = Mockito.mock(AssemblyServiceImpl::class.java)
        assemblyController = AssemblyController(assembleiaService)
        webTestClient = WebTestClient.bindToController(assemblyController).build()
    }

    @Test
    fun `post of assembly will return an valid assembly`() {
        given(assembleiaService.createAssembly())
                .willReturn(Mono.just(Assembly("1", null)))

        webTestClient.post()
                .uri("/assembleia")
                .exchange()
                .expectStatus().isCreated
                .expectBody(Assembly::class.java)
    }

    @Test
    fun `get will return a list`() {
        given(assembleiaService.getAssemblyList())
                .willReturn(Flux.just(Assembly(null, null), Assembly(null, null)))

        webTestClient.get()
                .uri("/assembleia")
                .exchange()
                .expectBodyList(Assembly::class.java)
                .hasSize(2)
    }

    @Test
    fun `get by id will return a single valid assembly`() {
        given(assembleiaService.getAssemblyById("1"))
                .willReturn(Mono.just(Assembly("1", null)))

        webTestClient.get()
                .uri("/assembleia/1")
                .exchange()
                .expectStatus().isOk
                .expectBody(Assembly::class.java)
    }

    @Test
    fun `put will update an assembly and return it`() {
        val assembly = Assembly("5", null)

        given(assembleiaService.update("2", assembly))
                .willReturn(Mono.just(assembly))

        val assemblyMono = Mono.just(assembly)

        webTestClient.put()
                .uri("/assembleia/1")
                .body(assemblyMono, Assembly::class.java)
                .exchange()
                .expectStatus().isOk
                .expectBody(Assembly::class.java)
    }

    @Test
    fun delete(){
        given(assembleiaService.getAssemblyById("1"))
                .willReturn(Mono.just(Assembly("1", null)))

        given(assembleiaService.delete("1"))
                .willReturn(Mono.empty())

        webTestClient.delete()
                .uri("/assembleia/1")
                .exchange()
                .expectStatus().isNoContent
    }
}