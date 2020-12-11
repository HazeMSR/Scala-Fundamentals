package lectures.part3fp

object TuplesAndMaps extends App {
  // tuples = finite ordered "lists"
  val aTuple = new Tuple2(2, "hello scala") // Tuple2[int, String] = (Int, String)
  println(aTuple._1)
  println(aTuple.copy( _2 = "goodbye Java"))
  println(aTuple.swap) // ("hello, Scala", 2)

  // Maps - keys -> values
  val aMap: Map[String, Int] = Map()

  val phonebook = Map(("Jim",555), ("JIM" -> 9000),("Daniel" -> 789)).withDefaultValue(-1)

  // a -> b is sugar for (a,b)
  println(phonebook)

  // map ops
  println(phonebook.contains("Jim"))
  println(phonebook("Jim"))

  //add a pairing
  val newPairing = "Mary" -> 678
  val newPhonebook = phonebook + newPairing
  println(newPhonebook)

  // functionals on maps
  // maps, flatMap, filter
  println("LOL:",phonebook.map(pair => pair._1.toLowerCase -> pair._2))

  // filterKeys
  println(phonebook.filterKeys( x => x.startsWith("J")).toMap)

  // mapValues
  println(phonebook.mapValues(number => number * 10))

  // conversion to other collections
  println(phonebook.toList)
  println(List(("Daniel", 555)).toMap)
  val names = List("Bob", "James", "Angela", "Mary", "Daniel", "Jim")
  println(names.groupBy(name => name.charAt(0)))

  /*
  1. What would happen if I had two original entries "Jim" -> 555 "JIM" -> 9007

    !!! CAREFUL WITH MAPPING KEYS

  2. Overly simplified social network based on maps
    Person = String
    - add a person to the network
    - remove
    - friend (mutual)
    - unfriend

    - number of friends of a person
    - person with most friends
    - how many people have NO friends
    - if there is a social connection between two people (direct or not)
   */

  def add(network: Map [String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map [String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)

    network + (a -> (friendsA - b)) + (b -> (friendsB -a))
  }

}
