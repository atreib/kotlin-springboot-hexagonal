package br.com.andretreib.api.domain.contracts

import br.com.andretreib.api.domain.models.IExampleModel
import kotlinx.coroutines.flow.Flow

interface IExampleService {
    fun findAll(): Flow<IExampleModel>
    fun create(message: String): IExampleModel?
}
