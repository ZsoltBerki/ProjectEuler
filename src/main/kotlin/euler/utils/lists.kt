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
