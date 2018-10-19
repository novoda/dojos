package com.novoda.dojos.bankaccount

import org.hamcrest.Matchers.equalTo
import org.junit.Assert.assertThat
import org.junit.Test

class AccountTest {

    private val account = Account()

    @Test
    fun `balance should be 0 when no deposits`() {
        account.assertBalanceEquals(0)
    }

    @Test
    fun `balance should be 10 when depositing 10`() {
        account.deposit(10)

        account.assertBalanceEquals(10)
    }

    @Test
    fun `balance should be 30 when depositing 10 and 20`() {
        account.deposit(10)
        account.deposit(20)

        account.assertBalanceEquals(30)
    }

    @Test
    fun `balance should be 10 when depositing 20 and withdrawing 10`() {
        account.deposit(20)
        account.withdraw(10)

        account.assertBalanceEquals(10)
    }

    @Test
    fun `balance should be 10 and 10 when transfering to another account`() {
        account.deposit(20)
        val anotherAccount = Account()

        account.transfer(amount = 10, to = anotherAccount)

        account.assertBalanceEquals(10)
        anotherAccount.assertBalanceEquals(10)
    }

    private fun Account.deposit(value: Int) = deposit(Amount(value))

    private fun Account.withdraw(value: Int) = withdraw(Amount(value))

    private fun Account.transfer(amount: Int, to: Account) = transfer(Amount(amount), to)

    private fun Account.assertBalanceEquals(value: Int) = assertThat(balance().amount.value, equalTo(value))
}
