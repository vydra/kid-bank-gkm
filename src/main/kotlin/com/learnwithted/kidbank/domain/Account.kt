package com.learnwithted.kidbank.domain

import com.google.common.collect.ImmutableList

import java.time.LocalDateTime

interface Account {
    fun balance(): Int

    fun deposit(transactionDateTime: LocalDateTime, amount: Int, source: String)

    fun spend(transactionDateTime: LocalDateTime, amount: Int, description: String)

    fun transactions(): ImmutableList<Transaction>

    fun load(transactionsToLoad: List<Transaction>)

    fun balanceUpTo(localDateTime: LocalDateTime): Int

    fun goals(): Set<Goal>

    fun createGoal(description: String, targetAmount: Int)
}
