package br.com.andretreib.api.presentation.handlers

import br.com.andretreib.api.domain.contracts.IExampleService
import br.com.andretreib.api.domain.errors.EmptyMessageException
import br.com.andretreib.api.domain.errors.InternalServerException
import br.com.andretreib.api.presentation.projections.IExampleResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.springframework.stereotype.Component

@Component
class ExampleHandler(private val exampleService: IExampleService) {
    fun findAll(): Flow<IExampleResponse> {
        return exampleService.findAll()
            .map { IExampleResponse(it.message, it.createdAt) }
    }

    fun create(message: String): IExampleResponse {
        if (message == "") throw EmptyMessageException()
        val createdMsg = exampleService.create(message) ?: throw InternalServerException()
        return IExampleResponse(createdMsg.message, createdMsg.createdAt)
    }
}
