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

    private fun Account.assertBalanceEquals(value: Int) = assertThat(balance().amount.value, equalTo(value))
}
