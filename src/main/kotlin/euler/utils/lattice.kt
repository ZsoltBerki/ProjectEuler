package euler.utils

/**
 * Returns every possible North-East lattice path on the given field.
 * If height is not given, the field is a square.
 */
fun countNorthEastLatticePaths(width: Long, height: Long = width): Long {
    val pathLength = width + height
    val fullOptions = MultiplicationList.getFact(pathLength)
    val widthDivider = MultiplicationList.getFact(width)
    val heightDivider = MultiplicationList.getFact(height)
    val result = fullOptions.divide(widthDivider).divide(heightDivider)
    return result.resolve()
}
