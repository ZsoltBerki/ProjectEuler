package euler.utils

/**
 * Return a list of natural numbers that are below @below
 * and are multiplies of @multipliesOf
 */
fun getMultipliesOf(multipliesOf: Int, below: Int): List<Int> {
    return (1 until below).filter { number -> number % multipliesOf == 0 }
}

/**
 * This structure allows you to work with multiplication lists (for example factorials)
 * and only resolve their final value when required.
 * This is because of the size limitations of the Long type.
 */
data class MultiplicationList(val numbers: List<Long>, val dividers: List<Long> = emptyList()) {
    companion object {
        fun getFact(number: Long): MultiplicationList {
            return MultiplicationList((1..number).toList())
        }
    }

    fun multiply(multiplierMl: MultiplicationList): MultiplicationList {
        return MultiplicationList(
            this.numbers + multiplierMl.numbers,
            this.dividers + multiplierMl.dividers
        ).simplify()
    }

    fun multiply(multipliers: List<Long>): MultiplicationList {
        return MultiplicationList(
            this.numbers + multipliers,
            this.dividers
        ).simplify()
    }

    fun multiply(multiplier: Long): MultiplicationList {
        return MultiplicationList(
            this.numbers + listOf(multiplier),
            this.dividers
        ).simplify()
    }

    fun divide(dividerMl: MultiplicationList): MultiplicationList {
        return MultiplicationList(
            this.numbers + dividerMl.dividers,
            this.dividers + dividerMl.numbers
        ).simplify()
    }

    fun divide(dividers: List<Long>): MultiplicationList {
        return MultiplicationList(
            this.numbers,
            this.dividers + dividers
        ).simplify()
    }

    fun divide(divider: Long): MultiplicationList {
        return MultiplicationList(
            this.numbers,
            this.dividers + listOf(divider)
        ).simplify()
    }

    fun simplify(): MultiplicationList {
        val tempNumbers = this.numbers.toMutableList()
        val tempDividers = mutableListOf<Long>()

        this.dividers.forEach { divider ->
            val indexInNumbers = tempNumbers.indexOf(divider)
            if (indexInNumbers >= 0) {
                tempNumbers.removeAt(indexInNumbers)
            } else {
                val indexOfDivisible = tempNumbers.indexOfFirst { number -> (number % divider) == 0L }
                if (indexOfDivisible >= 0) {
                    tempNumbers.set(indexOfDivisible, tempNumbers[indexOfDivisible] / divider)
                } else {
                    tempDividers.add(divider)
                }
            }
        }
        return MultiplicationList(tempNumbers, tempDividers)
    }

    fun resolve(): Long {
        val resolvedNumber = this.numbers.fold(1L, { acc, number -> acc * number })
        val dividedNumber = this.dividers.fold(1L, { acc, number -> acc * number })
        return resolvedNumber / dividedNumber
    }
}
