package euler.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FactorialTests {
    @Test
    @DisplayName("Testing getting the factorial")
    fun testGetFactorial() {
        Assertions.assertEquals(
            1,
            getFactorial(1),
            "Failed for 1"
        )
        Assertions.assertEquals(
            2,
            getFactorial(2),
            "Failed for 1"
        )
        Assertions.assertEquals(
            6,
            getFactorial(3),
            "Failed for 1"
        )
        Assertions.assertEquals(
            24,
            getFactorial(4),
            "Failed for 1"
        )
        Assertions.assertEquals(
            120,
            getFactorial(5),
            "Failed for 1"
        )
    }
}
