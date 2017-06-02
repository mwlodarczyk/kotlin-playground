package com.mwlodarczyk

import org.junit.Test
import java.math.BigDecimal

class S01_Introduction {

    data class Money(val amount: BigDecimal, val currency: String)

    //Default parameters
    fun sendPayment(money: Money, message: String = "") {
        println("Sending ${money.amount}")
    }

    //Expression functions
    fun sum(x: Int, y: Int) = x + y

    //Extension functions
    fun BigDecimal.percent(percentage: Int) = this * BigDecimal(percentage / 100)

    fun convertToDollars(money: Money): Money {
        when (money.currency) {
            "$" -> return money
            "EUR" -> return Money(money.amount * BigDecimal(1.10), "$")
            else -> throw IllegalArgumentException("wrong currency")
        }
    }

    @Test
    fun basicTypes() {

        val tickets = Money(BigDecimal(100), "$")
        val popcorn = Money(BigDecimal(500), "EUR")

        //There is also !== operator
        if (tickets != popcorn) {
            println("They are different!")
        }

        //Cal function
        sendPayment(tickets)

        //Great to pass parameters in any order we want
        sendPayment(message = "Good luck", money = tickets)
    }

}