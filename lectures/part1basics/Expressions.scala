package lectures.part1basics

object Expressions extends App {
  val x = 1 + 2
  println(x)

  println(2 +3 +4)

  // + - * / & | ^ << >> >>> (right shift with zero extension)

  println (1 == x)
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 //also works with -= += /= ... side efects
  println(aVariable)

  //Instructions (DO) vs Expresions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3 // IF EXPRESSION
  println(aCondition)


  var i = 0
  val aWhile: Unit = while (i < 10) {
    println(i)
      i += 1
  } //Never write this again

  //EVERYTHING in Scala is an Expression

  val aWeirdValue = (aVariable = 3) // Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  //code blocks

  var aCodeBlock = {
    val y = 2
    val z = y + 1
    if (z > 2) "hello" else "goodbye"
  }

  // 1. difference between "hello world" vs println("hello world")
  // 2.

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if (someValue) 239 else 986
    42
  }

}
