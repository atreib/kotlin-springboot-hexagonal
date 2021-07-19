package br.com.andretreib.example.domain.contracts

import br.com.andretreib.example.domain.models.IExampleModel
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IExampleService {
    fun findAll(): Flux<IExampleModel>
    fun create(message: String): Mono<IExampleModel>
}
