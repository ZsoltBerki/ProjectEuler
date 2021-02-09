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

    @Test
    @DisplayName("Test getting the prime factors of the number")
    fun testGetPrimeFactors() {
        val expected = listOf(Pair(2, 2), Pair(3, 1), Pair(5, 1)).toMap()
        val result = getPrimeFactors(60)
        assertEquals(expected, result, "for number 60")
    }

    @Test
    @DisplayName("Test getting the combined prime factors of numbers")
    fun testGetCombinedPrimeFactors() {
        val expected = listOf(Pair(2, 6), Pair(3, 1), Pair(5, 1), Pair(7, 1)).toMap()
        val result = getCombinedPrimeFactors(listOf(10, 21, 64))
        assertEquals(expected, result, "for numbers 10, 21, 64")
    }

    @Test
    @DisplayName("Test getting the number from prime factors")
    fun testGetNumberFromPrimeFactors() {
        val expected = 420L
        val result = getNumberFromPrimeFactors(listOf(Pair(2, 2), Pair(3, 1), Pair(5, 1), Pair(7, 1)).toMap())
        assertEquals(expected, result, "for numbers [2:2][3:1][5:1][7:1]")
    }

    @Test
    @DisplayName("Test getting the smallest evenly divisible number")
    fun testGetSmallestEvenlyDivisible() {
        val numbers = (1L..10L).toList()
        val expected = 2520L
        val result = getSmallestEvenlyDivisible(numbers)
        assertEquals(expected, result, "for numbers 1..10")
    }
}
