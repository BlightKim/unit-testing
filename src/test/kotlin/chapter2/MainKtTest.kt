package chapter2

import chapter2.list1.Customer
import chapter2.list1.Product
import chapter2.list1.Store
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

class MainKtTest {


    @Test
    fun purchase_succeeds_when_enough_inventory() {
        // Arrange
        val store = Store();
        store.addInventory(Product.Shampoo, 10)
        val customer = Customer()

        // Act
        val result = customer.purchase(store, Product.Shampoo, 5)

        // Assert
        assertEquals(true, result)
        assertEquals(5, store.getInventory(Product.Shampoo))
    }

    @Test
    fun purchase_fails_when_not_enough_inventory() {
        // Arrange
        val store = Store()
        store.addInventory(Product.Shampoo, 10)
        val customer = Customer()

        // Act
        val result = customer.purchase(store, Product.Shampoo, 15)

        // Assert
        assertFalse(result)
        assertEquals(10, store.getInventory(Product.Shampoo))
    }
}
