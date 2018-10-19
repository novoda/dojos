package com.novoda.dojos.bankaccount

class Account {

    private val transactions: MutableList<Amount> = mutableListOf(Amount(0))

    fun balance(): Balance = Balance(transactions.reduce { acc, amount -> acc + amount })

    fun deposit(amount: Int) {
        transactions.add(Amount(amount))
    }
}

data class Balance(val amount: Amount)

data class Amount(val value: Int) {
    operator fun plus(other: Amount) = Amount(value + other.value)
}
