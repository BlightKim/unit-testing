package chapter3

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.test.assertFalse

class DeliveryServiceTests {

    @Test
    fun `Delivery_with_a_past_date_is_invalid`() {
        val sut = DeliveryService()
        val pastDate = LocalDateTime.now().plusDays(-1)
        val delivery = Delivery(pastDate)

        val isValid = sut.isDeliveryValid(delivery)
        assertFalse(isValid)
    }

    companion object {
        fun data() = listOf(
            arrayOf(LocalDateTime.now().minusDays(1), false),
            arrayOf(LocalDateTime.now(), false),
            arrayOf(LocalDateTime.now().plusDays(1), false),
            arrayOf(LocalDateTime.now().plusDays(2), true)
        )
    }

    @ParameterizedTest
    @CsvSource(
        "-1, false",
        "0, false",
        "1, false",
        "2, true"
    )
    fun `Can_detect_an_invalid_delivery_date`(
        daysFromNow: Int,
        expected: Boolean
    ) {
        val sut = DeliveryService()
        val deliveryDate = LocalDateTime.now().plusDays(daysFromNow.toLong())
        val delivery = Delivery(deliveryDate)

        val isValid = sut.isDeliveryValid(delivery)

        assertEquals(expected, isValid)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 1])
    fun `Detects_an_invalid_delivery_date`(
        daysFromNow: Int
    ) {
        val sut = DeliveryService()
        val deliveryDate = LocalDateTime.now().plusDays(daysFromNow.toLong())
        val delivery = Delivery(deliveryDate)

        val isValid = sut.isDeliveryValid(delivery)

        assertFalse(isValid)
    }

}
