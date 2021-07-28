package br.com.andretreib.api.presentation.projections

import io.swagger.annotations.ApiModelProperty

data class IExampleRequest(
    @ApiModelProperty(notes = "Message to be stored in the Example repository", required = true)
    val message: String
)
