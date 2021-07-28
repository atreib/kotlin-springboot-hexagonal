package br.com.andretreib.api.presentation.projections

import br.com.andretreib.api.domain.models.IExampleModel
import io.swagger.annotations.ApiModelProperty
import java.util.Date

data class IExampleResponse(
    @ApiModelProperty(notes = "Message stored inside the Example repository", required = true)
    val message: String,

    @ApiModelProperty(notes = "Message creation date/time", required = true)
    val createdAt: Date
)

fun IExampleModel.toIExampleResponse() = IExampleResponse(
    message = message,
    createdAt = createdAt,
)
