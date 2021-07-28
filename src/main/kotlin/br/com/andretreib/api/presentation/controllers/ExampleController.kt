package br.com.andretreib.api.presentation.controllers

import br.com.andretreib.api.presentation.handlers.ExampleHandler
import br.com.andretreib.api.presentation.projections.IExampleRequest
import br.com.andretreib.api.presentation.projections.IExampleResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import kotlinx.coroutines.flow.Flow
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(path = ["/example"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Api(value = "example", description = "Example Service Rest API", tags = ["Example API"])
class ExampleController(private val exampleHandler: ExampleHandler) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/"])
    @ApiOperation(value = "Returns all messages from the Example repository", response = IExampleResponse::class, responseContainer = "List")
    @ApiResponses(
        value = [
            ApiResponse(
                code = 200,
                message = "List of messages"
            )
        ]
    )
    fun findAll(): Flow<IExampleResponse> = exampleHandler.findAll()

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(
        path = ["/"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ApiOperation(value = "Created a new message inside the Example repository", response = IExampleResponse::class)
    @ApiResponses(
        value = [
            ApiResponse(
                code = 200,
                message = "Created message"
            )
        ]
    )
    fun create(@RequestBody request: IExampleRequest): IExampleResponse = exampleHandler.create(request.message)
}
