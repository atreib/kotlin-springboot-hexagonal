package br.com.andretreib.example.infrastructure.contracts

import br.com.andretreib.example.domain.models.IExampleModel

interface IExampleRepository {
    fun findAll(): List<IExampleModel>
    fun create(message: String): IExampleModel
}
