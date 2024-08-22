package chapter1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MainKtTest {

    @Test
    fun isStringLong() {
        val result = Main.isStringLong("abc")
        assertEquals(result, false)
    }
}
