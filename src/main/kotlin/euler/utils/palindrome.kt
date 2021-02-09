package euler.utils

import kotlin.math.pow

/**
 * Returns true when the given number is a palindrome
 */
fun isPalindrome(number: Long): Boolean {
    val numberAsText = number.toString()
    val numberLength = numberAsText.count()
    val halfOfLength = numberLength / 2

    return if (numberLength == 1) {
        true
    } else {
        val firstHalf = numberAsText.substring(0, halfOfLength)
        val secondHalf = numberAsText.substring(numberLength - halfOfLength, numberLength)
        firstHalf == secondHalf.reversed()
    }
}

/**
 * Returns the largest palindrome created with the multiplications of two numbers
 * with the given digits.
 */
fun findLargestPalindrome(digits: Int): Long {
    val lowerBoundary = (10f).pow(digits - 1).toLong()
    val upperBoundary = ((10f).pow(digits) - 1).toLong()
    val rangeOfNumbers = lowerBoundary..upperBoundary

    var largestCandidate = 1L

    val evaluate = {
        number: Long ->
        if (number > largestCandidate && isPalindrome(number)) {
            largestCandidate = number
        }
    }

    rangeOfNumbers.forEach { numberA ->
        rangeOfNumbers.forEach { numberB ->
            evaluate(numberA * numberB)
        }
    }

    return largestCandidate
}
