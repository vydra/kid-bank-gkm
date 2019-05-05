package com.learnwithted.kidbank.domain




import java.time.LocalDateTime
import java.util.Objects
import java.util.function.Predicate


class Transaction {

    // EXTRINSIC property used by Repository

    var id: Long? = null
        set(id) {
            field = this.id
        }

    // INTRINSIC properties of Transaction
    private val date: LocalDateTime
    private val action: String
    private val amount: Int // scaled two decimal places, i.e., cents
    private val source: String

    constructor(date: LocalDateTime, action: String, amount: Int, source: String) {
        this.date = date
        this.action = action
        this.amount = amount
        this.source = source
    }

    fun dateTime(): LocalDateTime {
        return date
    }

    fun action(): String {
        return action
    }

    fun amount(): Int {
        return amount
    }

    fun source(): String {
        return source
    }

    fun signedAmount(): Int {
        return if (action == SPEND) -amount else amount
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as Transaction?

        return this.id == that!!.id
    }

    override fun hashCode(): Int {
        return if (this.id != null) this.id!!.hashCode() else 0
    }

    companion object {
        private val SPEND = "Spend"
        private val DEPOSIT = "Deposit"
        private val INTEREST = "Interest Credit"

        fun createSpend(localDateTime: LocalDateTime, amount: Int, source: String): Transaction {
            return Transaction(localDateTime, SPEND, amount, source)
        }

        fun createDeposit(localDateTime: LocalDateTime, amount: Int, source: String): Transaction {
            return Transaction(localDateTime, DEPOSIT, amount, source)
        }

        fun createInterestCredit(localDateTime: LocalDateTime, amount: Int): Transaction {
            return Transaction(localDateTime, INTEREST, amount, "Interest Credit")
        }

//        val isInterestCredit: Predicate<Transaction>
//            get() = { t -> t.action == INTEREST }
    }
}
