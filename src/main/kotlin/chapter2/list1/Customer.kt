package chapter2.list1

class Customer {
    fun purchase(store: Store, product: Product, quantity: Int): Boolean {
        return if (store.hasEnoughInventory(product, quantity)) {
            store.removeInventory(product, quantity)
            true
        } else {
            false
        }
    }
}
