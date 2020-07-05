package org.example.immutable_list

interface List<out A> {

}

data class Cons<A>(val a: A, val tail: List<A>): List<A>

object Nil: List<Nothing>

