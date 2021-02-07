@file:JvmName("Main")
package euler

import euler.utils.getMultipliesOf

fun main() {
    println("Hello, Euler!")
    task1()
}

/**
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9.
 * The sum of these multiples is 23.
 * Find the sum of all the multiples of 3 or 5 below 1000.
 */
fun task1() {
    println("Task 1")
    val multipliesOfFive = getMultipliesOf(5, 1000)
    val multipliesOfThree = getMultipliesOf(3, 1000)
    val multipliesOfFiveAndThree = multipliesOfFive.union(multipliesOfThree)
    println(multipliesOfFiveAndThree)
    println(multipliesOfFiveAndThree.sum())
}