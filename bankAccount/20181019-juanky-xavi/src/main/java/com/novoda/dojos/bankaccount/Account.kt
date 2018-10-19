package com.novoda.dojos.bankaccount

class Account {

    private val ledger: Ledger = Ledger()

    fun balance(): Balance = ledger.balance()

    fun deposit(amount: Amount) {
        ledger.deposit(amount)
    }

    fun withdraw(amount: Amount) {
        ledger.withdraw(amount)
    }

    fun transfer(amount: Amount, toAccount: Account) {
        ledger.withdraw(amount)
        toAccount.deposit(amount)
    }
}

data class Balance(val amount: Amount)

data class Ledger(val transactions: MutableList<Transaction> = mutableListOf()) {
    fun deposit(amount: Amount) {
        transactions.add(Deposit(amount))
    }

    fun withdraw(amount: Amount) {
        transactions.add(Withdrawal(amount))
    }

    fun balance(): Balance = Balance(transactions.fold(Amount(0)) { acc, transaction ->
        transaction.applyTo(acc)
    })
}

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
