package euler.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LatticePathTests {
    @Test
    @DisplayName("Testing getting the factorial")
    fun testCountLatticePaths() {
        fun testGetFactorial() {
            Assertions.assertEquals(
                2,
                countNorthEastLatticePaths(1),
                "Failed for [1:1]"
            )
            Assertions.assertEquals(
                6,
                countNorthEastLatticePaths(2),
                "Failed for [2:2]"
            )
            Assertions.assertEquals(
                10,
                countNorthEastLatticePaths(2, 3),
                "Failed for [2:3]"
            )
        }
    }
}
