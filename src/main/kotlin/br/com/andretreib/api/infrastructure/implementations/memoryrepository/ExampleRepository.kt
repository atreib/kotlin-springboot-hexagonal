package br.com.andretreib.api.infrastructure.implementations.memoryrepository

import br.com.andretreib.api.domain.models.IExampleModel
import br.com.andretreib.api.infrastructure.contracts.IExampleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import org.springframework.stereotype.Repository
import java.util.Date

@Repository
class ExampleRepository : IExampleRepository {
    private val examples: MutableList<IExampleModel> = mutableListOf()

    override fun findAll(): Flow<IExampleModel> = examples.asFlow()

    override fun create(message: String): IExampleModel? {
        val msg = IExampleModel(message, Date())
        examples.add(msg)
        return msg
    }
}
