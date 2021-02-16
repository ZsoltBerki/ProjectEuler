package euler.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PythagoreanTests {
    @Test
    @DisplayName("Test the PythagoreanTriplets")
    fun testIsPythagoreanTriplet() {
        Assertions.assertEquals(false, isPythagoreanTriplet(1,2,3), "Failed for 1,2,3.")
        Assertions.assertEquals(true, isPythagoreanTriplet(3,4,5), "Failed for 3,4,5.")
    }
}