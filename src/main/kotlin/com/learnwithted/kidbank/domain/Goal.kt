package com.learnwithted.kidbank.domain


data class Goal(val description: String, val targetAmount: Int) {


    // EXTRINSIC property used by Repository

    var id: Long? = null
        set(id) {
            field = this.id
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