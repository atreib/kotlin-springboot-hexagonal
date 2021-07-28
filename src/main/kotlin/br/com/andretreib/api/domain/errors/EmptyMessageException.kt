package br.com.andretreib.api.domain.errors

import org.springframework.http.HttpStatus
import org.springframework.web.server.ResponseStatusException

class EmptyMessageException() : ResponseStatusException(HttpStatus.BAD_REQUEST, "Property \"message\" can't be empty")
