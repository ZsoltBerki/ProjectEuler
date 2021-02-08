package euler.utils

/**
 * Return the largest prime factor of the given number.
 * We use mutable variables to avoid recursion and potential stackOverflow
 */
fun getLargestPrimeFactor(ofNumber: Long): Int {
    var number = ofNumber
    var potentialPrimeFactor = 2
    val isPrimeFactor = { number.rem(potentialPrimeFactor) == 0L }
    val reduceNumber = { number /= potentialPrimeFactor }
    val lookForAnotherPrimeFactor = { potentialPrimeFactor++ }
    val hasMorePrimes = { number > 1 }

    while (hasMorePrimes()) {
        when (isPrimeFactor()) {
            true -> reduceNumber()
            false -> lookForAnotherPrimeFactor()
        }
    }
    return potentialPrimeFactor
}
