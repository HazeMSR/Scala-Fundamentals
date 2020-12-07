package lectures.part2oop

object Inheritance extends App {
  // Single class inheritance
  sealed class Animal {
    val creatureType = "wild"
    def eat = println("ñomñom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // Constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // Overriding
  class Dog(override val creatureType: String) extends Animal {
    //override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("crunch crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // TYPE SUBSTITUTION (broad: polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  //overRIDING vs overLOADING

  // super

  // preventing overrides
  // 1. use final on a member
  // 2. use final on the entire class
  // 3. seal the class - extend classes in THIS FILE, prevent extension in other files
}
