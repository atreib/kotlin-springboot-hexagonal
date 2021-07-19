package br.com.andretreib.example.infrastructure.contracts

import br.com.andretreib.example.domain.models.IExampleModel
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface IExampleRepository {
    fun findAll(): Flux<IExampleModel>
    fun create(message: String): Mono<IExampleModel>
}
