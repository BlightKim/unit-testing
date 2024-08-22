package chapter3

import chapter2.list2.Customer
import chapter2.list2.Product
import chapter2.list2.Store
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CustomerTests {

    @Test
    fun `purchase_succeeds_when_enough_inventory`() {
        val store = createStoreWithInventory(Product.Shampoo, 10)
        val sut = createCustomer()

        val result = sut.purchase(store, Product.Shampoo, 5)

        assertTrue(result)
        assertEquals(5, store.getInventory(Product.Shampoo))
    }

    @Test
    fun `purchase_fails_when_not_enough_inventory`() {
        val store = createStoreWithInventory(Product.Shampoo, 10)
        val sut = createCustomer()

        val result = sut.purchase(store, Product.Shampoo, 15)

        assertFalse(result)
        assertEquals(10, store.getInventory(Product.Shampoo))
    }

    private fun createStoreWithInventory(product: Product, quantity: Int): Store {
        val store = Store()
        store.addInventory(product, quantity)
        return store
    }

    companion object {
        private fun createCustomer(): Customer = Customer()
    }
}
