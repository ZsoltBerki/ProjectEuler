package euler.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PalindromeTests {
    @Test
    @DisplayName("Test palindrome verification")
    fun testIsPalindrome() {
        listOf(
            Pair(true, 3L),
            Pair(true, 1234321L),
            Pair(true, 12344321L),
            Pair(true, 222L),
            Pair(true, 22L),
            Pair(false, 123L),
            Pair(false, 1232L)
        ).forEach { testPair ->
            Assertions.assertEquals(
                testPair.first,
                isPalindrome(testPair.second),
                "Failed for ${testPair.second}"
            )
        }
    }

    @Test
    @DisplayName("Test palindrome verification")
    fun testLargestPalindrome() {
        Assertions.assertEquals(9009, findLargestPalindrome(2))
    }
}
