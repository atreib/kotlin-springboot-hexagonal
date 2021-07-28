package br.com.andretreib.api.domain.implementations

import br.com.andretreib.api.domain.contracts.IExampleService
import br.com.andretreib.api.domain.models.IExampleModel
import br.com.andretreib.api.infrastructure.contracts.IExampleRepository
import kotlinx.coroutines.flow.Flow
import org.springframework.stereotype.Service

@Service
class ExampleService(private val exampleRepository: IExampleRepository) : IExampleService {
    override fun findAll(): Flow<IExampleModel> = exampleRepository.findAll()

    override fun create(message: String): IExampleModel? = exampleRepository.create(message)
}
