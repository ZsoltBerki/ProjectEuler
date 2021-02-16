package euler.utils

data class Triplet(val a: Int, val b: Int, val c: Int) {
    fun getSum() = a + b + c
    fun getProduct() = a * b * c
}