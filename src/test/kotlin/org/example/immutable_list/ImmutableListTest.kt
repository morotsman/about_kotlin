package org.example.immutable_list

import org.junit.Test
import kotlin.test.assertEquals

internal class ImmutableListTest {

    @Test
    fun `create an Empty List`() {
        assertEquals(Nil, Nil)
    }

    @Test
    fun `create a List with one element`() {
        assertEquals<List<Int>>(Cons(1, Nil), Cons(1, Nil))
    }

    @Test
    fun `create a List with several elements`() {
        assertEquals<List<Int>>(Cons(2, Cons(1, Nil)), Cons(2, Cons(1, Nil)))
    }

}
