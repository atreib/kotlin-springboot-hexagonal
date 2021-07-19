package br.com.andretreib.example.presentation.controllers

import br.com.andretreib.example.domain.contracts.IExampleService
import br.com.andretreib.example.presentation.projections.IExampleRequest
import br.com.andretreib.example.presentation.projections.IExampleResponse
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping(path = ["/example"], produces = [MediaType.APPLICATION_JSON_VALUE])
@Api(value = "example", description = "Rest API para operações do serviço example", tags = arrayOf("Example API"))
class ExampleController(private val exampleService: IExampleService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/"])
    @ApiOperation(value = "Retorna todas as mensagens no repositório Example", response = IExampleResponse::class, responseContainer = "List")
    @ApiResponses(
        value = [
            ApiResponse(
                code = 200,
                message = "OK"
            )
        ]
    )
    fun findAll(): Flux<IExampleResponse> = exampleService.findAll().map { IExampleResponse(it.message, it.createdAt) }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(
        path = ["/create"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    @ApiOperation(value = "Cria uma nova mensagem no repositório Example", response = IExampleResponse::class)
    @ApiResponses(
        value = [
            ApiResponse(
                code = 200,
                message = "OK"
            )
        ]
    )
    fun create(@RequestBody request: IExampleRequest): Mono<IExampleResponse> =
        exampleService.create(request.message).flatMap { Mono.just(IExampleResponse(it.message, it.createdAt)) }
}
