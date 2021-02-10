package euler.utils

import kotlin.math.pow

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

/**
 * Returns the prime factors of the given number in a Map.
 * For example, 60 will be [2:2][3:1][5:1]
 */
fun getPrimeFactors(ofNumber: Long): Map<Int, Int> {
    var primeFactors: MutableMap<Int, Int> = mutableMapOf()

    var number = ofNumber
    var potentialPrimeFactor = 2
    val isPrimeFactor = { number.rem(potentialPrimeFactor) == 0L }

    val savePrimeFactor = {
        val key = potentialPrimeFactor
        val currentCount = primeFactors[key]
        primeFactors.put(key, (currentCount ?: 0) + 1)
    }
    val reduceNumber = { number /= potentialPrimeFactor }
    val lookForAnotherPrimeFactor = { potentialPrimeFactor++ }
    val hasMorePrimes = { number > 1 }

    while (hasMorePrimes()) {
        when (isPrimeFactor()) {
            true -> {
                savePrimeFactor()
                reduceNumber()
            }
            false -> lookForAnotherPrimeFactor()
        }
    }
    return primeFactors
}

/**
 * Returns the combined list of prime factors of the given list.
 * For example:
 * Prime factors of 10 is [2:1][5:1]
 * Prime factors of 21 is [3:1][7:1]
 * The combined prime factors of [19,21] is [2:1][3:1][5:1][7:1]
 */
fun getCombinedPrimeFactors(numbers: List<Long>): Map<Int, Int> {
    val dividerPrimeFactors = numbers.map { getPrimeFactors(it) }
    val differentPrimeFactors = dividerPrimeFactors
        .map { it.keys }
        .fold(
            initial = emptySet<Int>(),
            operation = { allKeys, currentKeys -> allKeys.union(currentKeys) }
        )
    val primeFactorWeights = mutableMapOf<Int, Int>()

    differentPrimeFactors.forEach { primeFactor ->
        dividerPrimeFactors.forEach { weightList ->
            val newWeight = weightList.getOrDefault(primeFactor, 0)
            val currentWeight = primeFactorWeights.getOrDefault(primeFactor, 0)

            if (newWeight > currentWeight) {
                primeFactorWeights.put(primeFactor, newWeight)
            }
        }
    }
    return primeFactorWeights
}

/**
 * Creates a number from a primeFactor Map where
 * the keys are the prime factors and the values are their weights.
 * [2:2][3:1] -> 12
 */
fun getNumberFromPrimeFactors(primeFactors: Map<Int, Int>): Long {
    return primeFactors
        .toList()
        .map { primeWeightPair ->
            val prime = primeWeightPair.first
            val weight = primeWeightPair.second
            prime.toFloat().pow(weight)
        }
        .fold(1F, { acc, number -> acc * number })
        .toLong()
}

/**
 * Gets the smallest number that is evenly divisible every number in the given list.
 */
fun getSmallestEvenlyDivisible(numbers: List<Long>): Long {
    return getNumberFromPrimeFactors(getCombinedPrimeFactors(numbers))
}

/**
 * Returns the nth prime number.
 */
fun findNthPrime(nth: Long): Long {
    val primes = mutableListOf<Long>()
    var currentNumber = 2L
    while (primes.size < nth) {
        val dividableBy = primes.find { prime -> currentNumber % prime == 0L }
        if (dividableBy == null) {
            primes.add(currentNumber)
        }
        currentNumber++
    }
    return primes.last()
}
