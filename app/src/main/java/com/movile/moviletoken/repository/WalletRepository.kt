package com.movile.moviletoken.repository

object WalletRepository {

    var value = 1000.00
    var tokens = listOf<String>("134567", "778936", "553722", "789372", "334213")

    fun getToken(): String {
        return tokens.random()
    }

    fun credit(credit : Double) {
        value += credit
    }

    fun debit(debit : Double) {
        value -= debit
    }
}