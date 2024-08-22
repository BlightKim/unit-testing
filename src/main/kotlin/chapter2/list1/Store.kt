package chapter2.list1

class Store {
    private val inventory = mutableMapOf<Product, Int>()

    fun hasEnoughInventory(product: Product, quantity: Int): Boolean = getInventory(product) >= quantity

    fun removeInventory(product: Product, quantity: Int) {
        if (!hasEnoughInventory(product, quantity)) {
            throw Exception("Not enough inventory")
        }

        inventory[product] = inventory[product]?.minus(quantity) ?: 0
    }


    fun addInventory(product: Product, quantity: Int) {
        inventory[product] = (inventory[product] ?: 0) + quantity
    }

    fun getInventory(product: Product): Int = inventory[product] ?: 0
}
