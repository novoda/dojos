package com.novoda.dojos.bankaccount

class Account {

    private val transactions: MutableList<Transaction> = mutableListOf()

    fun balance(): Balance = Balance(transactions.fold(Amount(0)) { acc, transaction ->
        transaction.applyTo(acc)
    })

    fun deposit(amount: Amount) {
        transactions.add(Deposit(amount))
    }

    fun withdraw(amount: Amount) {
        transactions.add(Withdrawal(amount))
    }
}

data class Balance(val amount: Amount)

data class Amount(val value: Int) {
    operator fun plus(other: Amount) = Amount(value + other.value)
    operator fun minus(other: Amount) = Amount(value - other.value)
}

sealed class Transaction {
    abstract fun applyTo(amount: Amount): Amount
}

data class Deposit(val transactionAmount: Amount) : Transaction() {
    override fun applyTo(amount: Amount): Amount = amount + transactionAmount
}

data class Withdrawal(val transactionAmount: Amount) : Transaction() {
    override fun applyTo(amount: Amount): Amount = amount - transactionAmount
}
