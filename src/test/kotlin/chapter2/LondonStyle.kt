package chapter2

import chapter2.list2.Customer
import chapter2.list2.IStore
import chapter2.list2.Product
import io.mockk.*
import org.junit.jupiter.api.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LondonStyle {
    @Test
    fun `purchase_succeeds_when_enough_inventory`() {
        // Arrange
        val storeMock = mockk<IStore>()
        every { storeMock.hasEnoughInventory(Product.Shampoo, 5) } returns true
        every { storeMock.removeInventory(Product.Shampoo, 5)} just Runs
        val customer = Customer()

        // Act
        val result = customer.purchase(storeMock, Product.Shampoo, 5)

        // Assert
        assertTrue(result)
        verify(exactly = 1) { storeMock.removeInventory(Product.Shampoo, 5)}
    }

    fun `purchase_fails_when_not_enough_inventory`() {
        // Arrange
        val storeMock = mockk<IStore>()
        every { storeMock.hasEnoughInventory(Product.Shampoo, 5) } returns true
        val customer = Customer()

        // Act
        val result = customer.purchase(storeMock, Product.Shampoo, 5)

        // Assert
        assertFalse(result)
        verify(exactly = 0) { storeMock.removeInventory(Product.Shampoo, 5)}
    }

}
