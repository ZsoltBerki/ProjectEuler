package euler.utils

/**
 * Return a list of natural numbers that are below @below
 * and are multiplies of @multipliesOf
 */
fun getMultipliesOf(multipliesOf: Int, below: Int): List<Int> {
    return (1 until below).filter { number -> number % multipliesOf == 0 }
}
