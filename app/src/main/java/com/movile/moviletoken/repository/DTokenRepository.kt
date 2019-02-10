package com.movile.moviletoken.repository

import com.movile.moviletoken.dtoken.DToken

object  DTokenRepository {

    private val list = mutableListOf<DToken>()
    private val tokens = listOf<String>("AN2342","AN1123", "AN9090", "AN4221", "AN2311", "AN9021", "AN2211", "AN6677",
        "AN6321", "AN5556")

    init {
    }

    fun save(dtoken : DToken) {
        dtoken.id = tokens.random()
        list.add(dtoken)
    }

    fun getAllDToken() : MutableList<DToken> {

        return list;
    }



}