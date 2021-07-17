package br.com.andretreib.example.domain.contracts

import br.com.andretreib.example.domain.models.IExampleModel

interface IExampleService {
    fun findAll(): List<IExampleModel>
    fun create(message: String): IExampleModel
}
