package lectures.p4pm

import exercises.{Cons, Empty, MyList}

object AllThePatterns extends App {
   // 1 - Constants
  val x: Any = "Scala"
  val constans = x match {
    case 1 => "a number"
    case "Scala" => "THE scala"
    case true => "The Truth"
    case AllThePatterns => "A Singleton object"
  }

  // 2 - match anything
  // 2.1 Wildcard

  val matchAnything = x match {
    case _ => "Anything"
  }

  // 2.2 variable
  val matchAVariable = x match {
    case something => s"I've found $something"
  }

  // 3. tuples
  val aTuple = (1, 2)
  val matchATuple = aTuple match {
    case (1 , 1) =>
    case (something, 2) => s"I've found $something"
  }

  val nestedTuple = (1, (2, 3))
  val matchANestedTuple = nestedTuple match {
    case (_, (2, v)) => "Nested"
  }
  // PM can be NESTED!

  // 4 - case classes - constructor pattern
  // PM can be nested with CCs as well
  val aList: MyList[Int] = new Cons(1, new Cons(2, Empty))
  val matchAList = aList match {
    case Empty => "Empty"
    case Cons(head, Cons(subhead, subtail)) =>  "List"
  }

  // 5 - list patterns
  val aStandardList = List(1,2,3,42)
  val standardListMatching = aStandardList match {
    case List(1, _, _, _) => "Extractor"// extractor - advanced
    case List(1, _*) => "arbitrary" //list of arbitrary length - advanced
    case 1 :: List(_) => "infix" //infix pattern
    case List(1,2,3) :+ 42 => "simple infix" //infix pattern
  }

  // 6 - type specifiers
  val unknown: Any = 2
  val unknownMatch = unknown match {
    case list: List[Int] => "explicit" // explicit type specifier
    case _ => "whatever"
  }
/*
  // 7 - name binding
  val nameBindingMatch = aList match {
    case notEmptyList @ Cons(_, _) => "name" // name binding => use the name later (here)
    case Cons(1, rest @ Cons(2, _)) => "same name" // name binding inside nested patterns
  }

  // 8 - multi patterns
  val multipattern = aList match {
    case Empty | Cons(0, _) => "compound" // compound pattern (multi-pattern)
  }

  // 9 - if guards
  val secondElementSpecial = aList match {
    case Cons(_, Cons(specialElement, _)) if specialElement % 2 == 0 => "if"
  }
*/
  // ALL.

  /*
  Question.
   */
  val numbers = List(1,2,3)
  val numbersMatch = numbers match {
    //case listOfStrings: List[String] => "a List of Strings"
    case llistOfNumbers: List[Int] => "a list of numbers"
    case _ => ""
  }
  println(numbersMatch)
  // JVM trick question
}