package lectures.part1basics

import Expressions.i

object Functions extends App {
  def aFunction(a: String, b: Int): String = (
    a + " " + b
  )

  println(aFunction("hello",3))

  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = (
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  )

  //WHEN YOU NEED LOOPS, USE RECURSION

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n - 1)
  }
  /*
  * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  * 2. Factorial function 1 * 2 * 3 * ... * n
  * 3. Fibonacci function
  *    f(1) = 1
  *    f(2) = 1
  *    f(n) = f(n -1) + f(n - 2)
  * 4. Test if a number is prime
  * */

  def greetingFunction(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."
  println(greetingFunction("Hazel",24))

  def factorial( f: Int ): Int =
    if( f <= 0 ) 1
    else f * factorial( f - 1 )
 
  println(factorial(4))

  def fibonacci( f: Int ): Int =
    if ( f <= 2 ) 1
    else fibonacci( f - 1 ) + fibonacci( f - 2 )

  println(fibonacci(7))
  println(fibonacci(8))

  def isPrime( p: Int, i: Int = 2, result: Boolean = true ) : Boolean =
    if ( result && i < p/2 ) result && isPrime(p, i+1, (p % i) != 0)
    else result

  def isPrime2( n: Int ): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if( t <= 1 ) true
      else n % t != 0 && isPrimeUntil(t - 1)
    isPrimeUntil(n / 2)
  }

  println(isPrime(28))
  println(isPrime2(28))
}
