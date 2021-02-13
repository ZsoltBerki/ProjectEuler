package euler.utils

/**
 * Returns the factorial value of the given number
 */
fun getFactorial(number: Long): Long {
    return (1..number).reduce { acc, number -> acc * number }
}
