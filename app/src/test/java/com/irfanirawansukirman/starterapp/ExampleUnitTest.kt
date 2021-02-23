package com.irfanirawansukirman.starterapp

import io.mockk.every
import io.mockk.mockk
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun `test simple with mockk`() {
        val doc1 = mockk<Doc1>()
        val doc2 = mockk<Doc2>()

        every { doc1.value } returns 6
        every { doc2.value } returns 6

        val suc = Suc(doc1, doc2)

        assertEquals(12, suc.calculate())
    }

    @Test
    fun `test simple with mockk2`() {
        val doc1 = Doc1(6)
        val doc2 = Doc2(6)

        val suc = Suc(doc1, doc2)

        assertEquals(12, suc.calculate())
    }
}