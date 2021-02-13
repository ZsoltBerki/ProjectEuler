package euler.utils

/**
 * This a non-recursive generic function that can be used to generate lists.
 * @isReady a function that takes the current list and the next element and returns true when the list generation is ready.
 * @getNextElement a function that takes the current list and generates the next element
 */
fun <T> generateList(
    isReady: (currentList: List<T>, nextElement: T) -> Boolean,
    getNextElement: (currentList: List<T>) -> T
): List<T> {
    val list = emptyList<T>().toMutableList()
    var nextElement = getNextElement(list)
    while (!isReady(list, nextElement)) {
        list.add(nextElement)
        nextElement = getNextElement(list)
    }
    return list.toList()
}

/**
 * Goes through the list and applies the map function to a given window size.
 * If the list is [1,2,3,4], the window size is 2 and the map function is sum(), the result is [3,5,7]
 * If the window is bigger then the list, the map function will be executed for the whole list.
 */
fun <T, R> List<T>.windowMap(windowSize: Int, mapFunction: (window: List<T>) -> R): List<R> {
    if (this.size <= windowSize) {
        return listOf(mapFunction(this))
    }

    return (0..(this.size - windowSize))
        .map { startIndex -> mapFunction(this.subList(startIndex, startIndex + windowSize)) }
}
