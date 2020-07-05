package org.example.liskov

import java.lang.RuntimeException

object BreakingTheLaw1 {
    interface Fruit {
        val color: String
        val weightInGrams: Int
        fun calories(): Float
        //and so on
    }

    data class Apple(override val color: String, override val weightInGrams: Int) : Fruit {
        override fun calories(): Float = (weightInGrams.toFloat() / 100) * 52
    }

    data class Orange(override val color: String, override val weightInGrams: Int) : Fruit {
        override fun calories(): Float = (weightInGrams.toFloat() / 100) * 47
    }

    data class Ackee(override val color: String, override val weightInGrams: Int) : Fruit {
        override fun calories(): Float = throw RuntimeException("You can't eat this!")
    }


    data class Person(
        val name: String,
        val caloriesConsumed: Float = 0.0f,
        val weightOfConsumedFuits: Int = 0
    ) {
        fun eat(fruit: Fruit): Person =
            this.copy(
                caloriesConsumed = (caloriesConsumed + fruit.calories()),
                weightOfConsumedFuits = weightOfConsumedFuits + fruit.weightInGrams
            )

    }

    private fun caloriesAndWeightCalculator(person: Person, fruits: List<Fruit>): Person =
        fruits.fold(person) { acc, fruit -> acc.eat(fruit) }


    @JvmStatic
    fun main(args: Array<String>) {
        val consumedFruits = listOf(
            Apple("Red", 50),
            Apple("Red", 100),
            Orange("Orange", 100),
            Ackee("Orange", 100)
        )

        println(caloriesAndWeightCalculator(Person("Niklas"), consumedFruits))

        val inventory = mapOf<Fruit, Int>(

        )

    }
}


object FollowThePrinciple {
    interface Fruit {
        val color: String
        val weightInGrams: Int
        //and so on
    }

    interface EatableFruit : Fruit {
        fun calories(): Float
    }

    data class Apple(override val color: String, override val weightInGrams: Int) : EatableFruit {
        override fun calories(): Float = (weightInGrams.toFloat() / 100) * 52
    }

    data class Orange(override val color: String, override val weightInGrams: Int) : EatableFruit {
        override fun calories(): Float = (weightInGrams.toFloat() / 100) * 47
    }

    data class Ackee(override val color: String, override val weightInGrams: Int) : Fruit


    data class Person(
        val name: String,
        val caloriesConsumed: Float = 0.0f,
        val weightOfConsumedFuits: Int = 0
    ) {
        fun eat(fruit: EatableFruit): Person =
            this.copy(
                caloriesConsumed = (caloriesConsumed + fruit.calories()),
                weightOfConsumedFuits = weightOfConsumedFuits + fruit.weightInGrams
            )

    }

    private fun caloriesAndWeightCalculator(person: Person, fruits: List<EatableFruit>): Person =
        fruits.fold(person) { acc, fruit -> acc.eat(fruit) }


    @JvmStatic
    fun main(args: Array<String>) {
        val consumedFruits = listOf(
            Apple("Red", 50),
            Apple("Red", 100),
            Orange("Orange", 100)//,
            // Ackee("Red", 100)
        )

        println(caloriesAndWeightCalculator(Person("Niklas"), consumedFruits))
    }
}

