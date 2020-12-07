package lectures.part1basics

import scala.annotation.tailrec
import scala.jdk.Accumulator

object Recursion extends App {


  def factorial( f: Int ): BigInt =
    if( f <= 0 ) 1
    else f * factorial( f - 1 )
  //factorial(9999)

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator
      else factHelper(x - 1, x * accumulator) //TAIL RECURSION = use recursive call as the LAST expression

    factHelper(n, 1)
  }
  println(anotherFactorial(5000))

  /*
  1. Concatenate a string n times.
  2. IsPrime with tail recursive
  3. Fibonacci with tail recursive
   */
  def multiplyString(s: String, n: Int): String = {
    @tailrec
    def multiHelper(x: String, i: Int, accumulator: String): String = {
      if (i <= 0) accumulator
      else multiHelper (x, i - 1, x + accumulator)
    }
    multiHelper(s, n, "")
  }
  println(multiplyString("owo",3))

  @tailrec
  def concatenateTailrec(s: String, n: Int, accumulator: String): String =
    if (n <= 0) accumulator
    else concatenateTailrec(s, n-1, s + accumulator )

  println(concatenateTailrec("owo",3,""))

  def isPrimeTail(p: BigInt): Boolean = {
    val half = p/2
    @tailrec
    def primeHelper(x: Int, accumulator: Boolean): Boolean = {
      if (!accumulator) false
      else if ( x > half ) accumulator
      else primeHelper( x + 1, (p % x) != 0 && accumulator)
    }
    primeHelper(2,true)
  }
  println(isPrimeTail(347483663))
  println(isPrimeTail(29))

  def fibonacciTail(f: Int): BigInt = {
    @tailrec
    def fiboHelper(x: Int, accumulator: BigInt ): BigInt = {
      if( x <= f ) accumulator
      else fiboHelper( x - 1, accumulator + x - 2)
    }
    fiboHelper(3,1)
  }
  println(fibonacciTail(8))

  def fibonacci(n: Int) : Int = {
    @tailrec
    def fiboTailrec(i: Int, last: Int, nextToLast: Int): Int = {
      if (i >= n) last
      else fiboTailrec(i + 1, last + nextToLast, last)
    }
    if(n <= 2) 1
    else fiboTailrec(2, 1, 1)
  }
  println(fibonacci(4))
}
