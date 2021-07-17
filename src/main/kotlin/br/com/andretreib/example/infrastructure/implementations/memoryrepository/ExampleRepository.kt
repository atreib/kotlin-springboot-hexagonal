package br.com.andretreib.example.infrastructure.implementations.memoryrepository

import br.com.andretreib.example.domain.models.IExampleModel
import br.com.andretreib.example.infrastructure.contracts.IExampleRepository
import org.springframework.stereotype.Repository
import java.util.Date

@Repository
class ExampleRepository : IExampleRepository {
    private val examples: MutableList<IExampleModel> = mutableListOf()

    override fun findAll(): List<IExampleModel> = examples

    override fun create(message: String): IExampleModel {
        val msg = IExampleModel(message, Date())
        examples.add(msg)
        return msg
    }
}
