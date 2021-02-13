package euler.utils

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MultiplicationListTest {
    @Test
    @DisplayName("Testing MultiplicationList.getFact")
    fun testGetFact() {
        Assertions.assertEquals(
            listOf(1L, 2L, 3L, 4L, 5L),
            MultiplicationList.getFact(5).numbers.sorted(),
            "For fact 5"
        )
    }

    @Test
    @DisplayName("Testing MultiplicationList.multiply")
    fun testMultiply() {
        val factFive = MultiplicationList.getFact(5)
        val factThree = MultiplicationList.getFact(3)
        Assertions.assertEquals(
            listOf(1L, 1L, 2L, 2L, 3L, 3L, 4L, 5L),
            factFive.multiply(factThree).numbers.sorted(),
            "For 5! * 3!"
        )
    }

    @Test
    @DisplayName("Testing MultiplicationList.divide for factorials")
    fun testDivide() {
        val factFive = MultiplicationList.getFact(5)
        val factThree = MultiplicationList.getFact(3)
        Assertions.assertEquals(
            listOf(4L, 5L),
            factFive.divide(factThree).numbers.sorted(),
            "For 5! * 3!"
        )
    }

    @Test
    @DisplayName("Testing MultiplicationList.divide for odd lists")
    fun testDivideOdd() {
        val list1 = MultiplicationList(listOf(4, 5, 6))
        val list2 = MultiplicationList(listOf(2, 3, 7))
        Assertions.assertEquals(
            listOf(2L, 2L, 5L),
            list1.divide(list2).numbers.sorted(),
            "For [4,5,6]/[2,3,7]"
        )
        Assertions.assertEquals(
            listOf(7L),
            list1.divide(list2).dividers.sorted(),
            "For [4,5,6]/[2,3,7]"
        )
    }
}
