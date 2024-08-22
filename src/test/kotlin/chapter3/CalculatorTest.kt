package chapter3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {
    @Test
    fun `sum_of_two_numbers`() {
        // Arrange
        val first = 10.0
        val second = 20.0
        val sut = Calculator()

        // Act
        val result = sut.sum(first, second)

        // Assert
        assertEquals(30.0, result)
    }
}
