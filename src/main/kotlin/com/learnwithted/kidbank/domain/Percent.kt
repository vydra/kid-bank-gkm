package com.learnwithted.kidbank.domain

class Percent private constructor(private val numerator: Int, private val denominator: Int) {

    override fun toString(): String {
        return roundToInteger().toString() + "%"
    }

    fun roundToInteger(): Int {
        if (numerator >= denominator) {
            return 100
        }

        val rawPercent = 100.0 * numerator / denominator
        val roundedPercent = (rawPercent + .5).toInt()

        return if (roundedPercent < 100) roundedPercent else 99
    }

    class PercentBuilder internal constructor(private val numerator: Int) {

        fun over(denominator: Int): Percent {
            return Percent(numerator, denominator)
        }
    }

    companion object {

        fun of(numerator: Int): PercentBuilder {
            return PercentBuilder(numerator)
        }
    }
}
