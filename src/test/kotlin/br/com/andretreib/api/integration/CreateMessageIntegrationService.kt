package br.com.andretreib.api.integration

import br.com.andretreib.api.presentation.projections.IExampleRequest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.reactive.server.WebTestClient

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class CreateMessageIntegrationService {

    @Autowired
    private lateinit var client: WebTestClient

    @Test
    fun `should create a message`() {
        val messageRequest = "mock_message"
        client.post()
            .uri("/example/")
            .headers {
                it.accept = listOf(MediaType.APPLICATION_JSON)
                it.contentType = MediaType.APPLICATION_JSON
            }
            .bodyValue(IExampleRequest(messageRequest))
            .exchange()
            .expectStatus().isOk
            .expectBody()
            .jsonPath("$.message").isEqualTo(messageRequest)
            .jsonPath("$.createdAt").isNotEmpty
    }
}
