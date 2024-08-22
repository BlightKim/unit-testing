package chapter3

import java.time.LocalDateTime

class DeliveryService {
    fun isDeliveryValid(delivery: Delivery): Boolean {
        return delivery.date.isAfter(LocalDateTime.now().plusDays(1).plusNanos(999_999_999))
    }
}
