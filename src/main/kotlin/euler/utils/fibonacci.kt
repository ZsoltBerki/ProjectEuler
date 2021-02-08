package euler.utils

/**
 * This function returns the next value of a given fibonacci sequence
 * @currentSequence is the current fibonacci sequence
 */
fun getNextFibonacciValue(currentSequence: List<Int>): Int {
    return when (val listSize = currentSequence.size) {
        0 -> 1
        1 -> 2
        else -> currentSequence[listSize - 2] + currentSequence[listSize - 1]
    }
}

/**
 * Generates a fibonacci sequence whose highest number will not exceed the given threshold
 * @threshold the highest number in the sequence has to be lower then this number
 */
fun generateFibonacci(threshold: Int): List<Int> {
    return generateList(
        isReady = { _: List<Int>, nextElement: Int -> nextElement > threshold },
        getNextElement = ::getNextFibonacciValue
    )
}
