package euler.utils

import kotlin.math.pow

/**
 * Returns the sum of squares of the given numbers
 */
fun getSumOfSquares(numbers: List<Float>): Float {
    return numbers.map { it.pow(2) }.sum()
}

/**
 * Returns the square of sum of the given numbers
 */
fun getSquareOfSums(numbers: List<Float>): Float {
    return numbers.sum().pow(2)
}
