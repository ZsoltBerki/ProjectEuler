package euler.utils

/**
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which, a2 + b2 = c2
 */
fun isPythagoreanTriplet(a: Int, b: Int, c: Int): Boolean {
    return c > b && b > a && ((a * a) + (b * b) == (c * c))
}