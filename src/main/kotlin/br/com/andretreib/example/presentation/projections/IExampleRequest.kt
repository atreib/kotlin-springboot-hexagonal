package br.com.andretreib.example.presentation.projections

import io.swagger.annotations.ApiModelProperty

data class IExampleRequest(
    @ApiModelProperty(notes = "Mensagem a ser persistida no repositório Example", required = true)
    val message: String
)
