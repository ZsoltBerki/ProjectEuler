package euler.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PrimeTests {
    @Test
    @DisplayName("Test largest prime factor")
    fun testLargestPrimeFactor() {
        assertEquals(3, getLargestPrimeFactor(3))
        assertEquals(5, getLargestPrimeFactor(15))
        assertEquals(2, getLargestPrimeFactor(1024))
        assertEquals(29, getLargestPrimeFactor(13195))
    }
}
