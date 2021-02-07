package com.irfanirawansukirman.starterapp

/**
 * Created by Irfan Irawan Sukirman on 1/26/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */
class Suc(private val doc1: Doc1, private val doc2: Doc2) {
    fun calculate() = doc1.value.plus(doc2.value)
}