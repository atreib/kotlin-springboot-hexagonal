package br.com.andretreib.example.presentation.projections

import io.swagger.annotations.ApiModelProperty
import java.util.Date

data class IExampleResponse(
    @ApiModelProperty(notes = "Mensagem persistida no repositório Example", required = true)
    val message: String,

    @ApiModelProperty(notes = "Data/hora de criação da mensagem", required = true)
    val createdAt: Date
)
