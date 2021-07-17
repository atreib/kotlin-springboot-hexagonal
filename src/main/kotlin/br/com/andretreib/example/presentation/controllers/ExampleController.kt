package br.com.andretreib.example.presentation.controllers

import br.com.andretreib.example.domain.contracts.IExampleService
import br.com.andretreib.example.presentation.projections.IExampleRequest
import br.com.andretreib.example.presentation.projections.IExampleResponse
import br.com.andretreib.example.presentation.projections.toIExampleResponse
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
class ExampleController(private val exampleService: IExampleService) {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = ["/"])
    fun findAll(): List<IExampleResponse> = exampleService.findAll().map { IExampleResponse(it.message, it.createdAt) }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(
        path = ["/create"],
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody request: IExampleRequest): IExampleResponse =
        exampleService.create(request.message).toIExampleResponse()
}
