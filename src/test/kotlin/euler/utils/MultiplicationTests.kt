package euler.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MultiplicationTests {
    @Test
    @DisplayName("Testing multipliesOf")
    fun testMultipliesOf() {
        assertEquals(emptyList<Int>(), getMultipliesOf(100, 50), "Test for empty list.")
        assertEquals(listOf(5, 10, 15), getMultipliesOf(5, 20), "Test for non-empty list.")
    }
}