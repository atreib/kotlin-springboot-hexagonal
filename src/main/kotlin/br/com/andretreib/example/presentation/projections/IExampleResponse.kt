package br.com.andretreib.example.presentation.projections

import br.com.andretreib.example.domain.models.IExampleModel
import java.util.Date

data class IExampleResponse(val message: String, val createdAt: Date)

fun IExampleModel.toIExampleResponse() = IExampleResponse(
    message = message,
    createdAt = createdAt,
)
