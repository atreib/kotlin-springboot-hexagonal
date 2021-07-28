package br.com.andretreib.api.domain.implementations

import br.com.andretreib.api.domain.models.IExampleModel
import br.com.andretreib.api.infrastructure.contracts.IExampleRepository
import kotlinx.coroutines.flow.asFlow
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.Date

internal class ExampleServiceTest {
    private val exampleRepository: IExampleRepository = Mockito.mock(IExampleRepository::class.java)
    private val exampleService: ExampleService = ExampleService(exampleRepository)

    @Test
    fun `should call repository's findAll()`() {
        exampleService.findAll()
        Mockito.verify(exampleRepository).findAll()
    }

    @Test
    fun `should return repository's messages`() {
        val mockMessages = listOf(
            IExampleModel("mock_1", Date()),
            IExampleModel("mock_2", Date()),
        ).asFlow()
        Mockito.`when`(exampleRepository.findAll()).thenReturn(mockMessages)
        val response = exampleService.findAll()
        assertEquals(mockMessages, response)
    }

    @Test
    fun `should call repository's create() with provided message`() {
        val msg = "mock_message"
        exampleService.create(msg)
        Mockito.verify(exampleRepository).create(msg)
    }

    @Test
    fun `should return message created in repository`() {
        val msg = "mock_message"
        val createdMsg = IExampleModel(msg, Date())
        Mockito.`when`(exampleRepository.create(msg)).thenReturn(createdMsg)
        val response = exampleService.create(msg)
        assertEquals(createdMsg, response)
    }
}
