package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)

  val novel = new Novel ("Great Expectations", 1861, author)
  novel.authorAge()
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor))

  val counter = new Counter(1)
  counter.inc.print
  counter.inc(10).print
  counter.dec.print
}

// constructor
class Person(name: String, val age: Int = 0) {
  //body
  val x = 2
  println( 1 + 3 )

  // method
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // Overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

// class parameters are NOT FIELDS

/*
Novel and a Writer

Writer: first name, surname, year
- method fullname

Novel: name, year of release, author
- authorAge
- isWrittenBy(author)
- copy (new year of release) = new instance of novel
 */

class Writer(val firstName: String, val surname: String, val year: Int) {
  def fullname(): Unit = println(s"$firstName $surname")
}

class Novel(val name: String, val yearRelease: Int, val author: Writer) {
  def authorAge(): Unit = println(s"The author's age is ${yearRelease - author.year}")
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}
/*
Counter class
- receives an int value
- method current count
- method to increment/decrement => new Counter
- overload inc/dec to receive an amout
 */

class Counter(val count: Int = 0) {
  def inc = new Counter (count + 1) // Immutability
  def dec = new Counter (count - 1)

  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n-1)
  }

  def dec(n: Int): Counter = {
    if(n <= 0) this
    else dec.dec(n-1)
  }

  def print = println(s"The current value is $count")
}