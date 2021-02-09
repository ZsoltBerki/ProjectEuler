package euler.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SquaresTests {
    @Test
    @DisplayName("Testing sum of squares")
    fun testSumOfSquares() {
        Assertions.assertEquals(
            385,
            getSumOfSquares((1..10).toList().map { it.toFloat() }).toInt(),
            "Failed for 1..10"
        )
    }

    @Test
    @DisplayName("Testing square of sum")
    fun testSquareOfSums() {
        Assertions.assertEquals(
            3025,
            getSquareOfSums((1..10).toList().map { it.toFloat() }).toInt(),
            "Failed for 1..10"
        )
    }
}
