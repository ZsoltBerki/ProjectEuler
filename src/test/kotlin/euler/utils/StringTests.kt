package euler.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class StringTests {
    @Test
    @DisplayName("Test toNumbers")
    fun testToNumbers() {
        Assertions.assertEquals(
            listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1).map { it.toByte() },
            "12345678901".toByteList(),
            "Failed for 12345678901"
        )
    }

    @Test
    @DisplayName("Test toNumbers with extra chars")
    fun testToNumbersWithExtraChars() {
        val text =
            """
            123
            456
            7o9
            """.trimIndent()

        Assertions.assertEquals(
            listOf(1, 2, 3, 4, 5, 6, 7, 9).map { it.toByte() },
            text.toByteList(),
            "Failed for 12345678901"
        )
    }
}
