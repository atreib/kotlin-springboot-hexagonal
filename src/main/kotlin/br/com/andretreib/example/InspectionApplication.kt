package br.com.andretreib.example

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class InspectionApplication

fun main(args: Array<String>) {
    runApplication<InspectionApplication>(*args)
}
