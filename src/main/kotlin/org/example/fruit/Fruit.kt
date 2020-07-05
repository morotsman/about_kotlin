package org.example.fruit

interface Fruit
interface PoisonousFruit: Fruit
interface EatableFruit: Fruit

class Ackee: PoisonousFruit
class Apple: EatableFruit
class Orange: EatableFruit
