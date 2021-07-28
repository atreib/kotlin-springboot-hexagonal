package br.com.andretreib.api.infrastructure.contracts

import br.com.andretreib.api.domain.models.IExampleModel
import kotlinx.coroutines.flow.Flow

interface IExampleRepository {
    fun findAll(): Flow<IExampleModel>
    fun create(message: String): IExampleModel?
}
