// Lecture 1.2
def square(x: Double) = x * x
def sumOfSquares(x: Double, y: Double) = square(x) + square(y)
sumOfSquares(3, 2 + 2)
def area(radius: Double) = {
  def pi = 3.14159

  pi * square(radius)
}
area(10)

// Lecture 1.4
// boolean expressions
def a = 3
def b = 4
true && a == a
a != a || true
a < b && false
a > b

// differennce between val and def
//def loop: Boolean = loop
//def x = loop
//val y = loop /// ran forever

def and(x: Boolean, y: Boolean) = if (x) y else false
def or(x: Boolean, y: Boolean) = if (x) true else y
and(true, true)
or(false, true)

// Lecture 1.5
def abs(x: Double) = if (x < 0) -x else x
def sqrt(x: Double) = {
  def sqrtIter(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))

  def isGoodEnough(guess: Double) =
    abs(square(guess) - x) / x < 1e-3

  def improve(guess: Double) = (guess + x / guess) / 2

  sqrtIter(1.0)
}
sqrt(2)
sqrt(4)
sqrt(1e-6)
sqrt(1e60)

// Lecture 1.6
val x = 0
def f(y: Int) = y + 1
val result = {
  val x = f(3)
  x * x
} + x

// Lecture 1.7
// greatest common divisor
def gcd(a: Int, b: Int): Int =
  if(b==0) a
  else gcd(b, a%b)


gcd(14, 21)

// factorials
def factorial(n:Int): Int=
  if(n==0) 1
  else n * factorial (n-1)
factorial(4)

// tail recursive factorial
def tailFactorial(n: Int): Int = {
  def loop(acc: Int, n: Int): Int =
    if (n==0) acc
    else loop(acc * n, n-1)
  loop(1, n)
}

tailFactorial(4)