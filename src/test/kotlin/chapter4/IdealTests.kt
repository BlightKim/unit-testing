package chapter4

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class IdealTests {
    @Test
    fun test() {
        var sut = User()

        sut.name = "John Smith"

        assertEquals("John Smith", sut.name)
    }
}
