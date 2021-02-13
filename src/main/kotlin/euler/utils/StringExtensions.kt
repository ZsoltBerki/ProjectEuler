package euler.utils

/**
 * Turns the given string into a number list.
 * "1234" => listOf(1,2,3,4)
 */
fun String.toByteList(): List<Byte> {
    return this.toCharArray()
        .map { character -> (character.toShort() - 48).toByte() }
        .filter { number -> number in 0..9 }
}
