package br.com.andretreib.example.domain.implementations

import br.com.andretreib.example.domain.contracts.IExampleService
import br.com.andretreib.example.domain.models.IExampleModel
import br.com.andretreib.example.infrastructure.contracts.IExampleRepository
import org.springframework.stereotype.Service

@Service
class ExampleService(private val exampleRepository: IExampleRepository) : IExampleService {
    override fun findAll(): List<IExampleModel> = exampleRepository.findAll()

    override fun create(message: String): IExampleModel = exampleRepository.create(message)
}
