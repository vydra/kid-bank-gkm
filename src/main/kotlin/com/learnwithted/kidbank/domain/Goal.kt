package com.learnwithted.kidbank.domain


class Goal {
    private val description: String
    private val targetAmount: Int

    // EXTRINSIC property used by Repository

    var id: Long? = null
        set(id) {
            field = this.id
        }

    constructor(description: String, targetAmount: Int) {
        this.description = description
        this.targetAmount = targetAmount
    }

    fun description(): String {
        return description
    }

    fun targetAmount(): Int {
        return targetAmount
    }

    fun progressMadeWith(amount: Int): Percent {
        return Percent.of(amount).over(targetAmount)
    }


    fun remainingAmount(amount: Int): Int {
        return Math.max(targetAmount - amount, 0)
    }

}
