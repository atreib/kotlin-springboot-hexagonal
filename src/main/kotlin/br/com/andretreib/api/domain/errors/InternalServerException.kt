package br.com.andretreib.api.domain.errors

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class InternalServerException() : ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error")
