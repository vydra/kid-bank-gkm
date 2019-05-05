package com.learnwithted.kidbank.domain

import org.junit.Test

import org.assertj.core.api.Assertions.assertThat

class GoalProgressTest {

    @Test
    @Throws(Exception::class)
    fun noProgressMadeIsZeroPercentProgress() {
        val goal = Goal("goal", 100)

        val percent = goal.progressMadeWith(0)

        assertThat(percent.roundToInteger())
                .isZero()
    }

    @Test
    @Throws(Exception::class)
    fun goalIsHalfwayReturns50PercentProgress() {
        val goal = Goal("goal", 1000)

        val percent = goal.progressMadeWith(500)

        assertThat(percent.roundToInteger())
                .isEqualTo(50)
    }

    @Test
    @Throws(Exception::class)
    fun goalIsAlmostHalfwayRoundsTo50PercentProgress() {
        val goal = Goal("goal", 1000)

        val percent = goal.progressMadeWith(495)

        assertThat(percent.roundToInteger())
                .isEqualTo(50)
    }

    @Test
    @Throws(Exception::class)
    fun goalIsJustLessThanHalfwayRoundsTo49PercentProgress() {
        val goal = Goal("goal", 1000)

        val percent = goal.progressMadeWith(494)

        assertThat(percent.roundToInteger())
                .isEqualTo(49)
    }

    @Test
    @Throws(Exception::class)
    fun percentStaysAt99UntilGoalIsFullyMet() {
        val goal = Goal("goal", 1000)

        val percent = goal.progressMadeWith(999) // so close!

        assertThat(percent.roundToInteger())
                .isEqualTo(99)
    }

    @Test
    @Throws(Exception::class)
    fun goalIsMetReturns100PercentProgress() {
        val goal = Goal("goal", 1000)

        val percent = goal.progressMadeWith(1000)

        assertThat(percent.roundToInteger())
                .isEqualTo(100)
    }

    @Test
    @Throws(Exception::class)
    fun goalIsExceededStillReturns100PercentProgress() {
        val goal = Goal("goal", 1000)

        val percent = goal.progressMadeWith(1100)

        assertThat(percent.roundToInteger())
                .isEqualTo(100)
    }

    @Test
    @Throws(Exception::class)
    fun amountRemainingIsTargetAmountMinusGivenAmount() {
        val goal = Goal("goal", 1000)

        val remaining = goal.remainingAmount(900)

        assertThat(remaining)
                .isEqualTo(100)
    }

    @Test
    @Throws(Exception::class)
    fun amountRemainingIsZeroIfGivenAmountExceedsTarget() {
        val goal = Goal("goal", 1000)

        val remaining = goal.remainingAmount(2200)

        assertThat(remaining)
                .isZero()
    }

}