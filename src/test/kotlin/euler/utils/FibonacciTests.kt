package euler.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FibonacciTests {
    @Test
    @DisplayName("Calculation of the next fibonacci value")
    fun testNextValue() {
        assertEquals(1, getNextFibonacciValue(listOf()), "Does not work for empty list.")
        assertEquals(2, getNextFibonacciValue(listOf(1)), "Does not work for single element list.")
        assertEquals(3, getNextFibonacciValue(listOf(1,2)), "Value is incorrect")
        assertEquals(5, getNextFibonacciValue(listOf(1,2,3)), "Value is incorrect")
        assertEquals(8, getNextFibonacciValue(listOf(1,2,3,5)), "Value is incorrect")
    }

    @Test
    @DisplayName("Generation of fibonacci sequence")
    fun testSequenceGeneration() {
        assertEquals(listOf(1, 2, 3, 5, 8, 13, 21, 34, 55, 89), generateFibonacci(100))
    }
}