/*
 * Lecture 2.2
 * Currying
 *
 * use a function to return another function
 */

def sum(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if (a > b) 0 else f(a) + sumF(a + 1, b)
  sumF
}


def cube(a: Int): Int = a * a * a
def factorial_old(a: Int): Int =
  if (a == 0) 1 else a * factorial_old(a - 1)

def sumInts = sum(x => x)
def sumCubes = sum(x => x * x * x)
def sumFactorial = sum(x => factorial_old(x))

sumInts(1, 3) == 6
sumCubes(1, 3) == 36
sumFactorial(1, 3) == 9

sum(cube) (1, 3) == sumCubes(1, 3)

// 1 Exercise: write product function
def product(f: Int => Int)(a: Int, b: Int): Int = {
    if(a > b) 1 else f(a) * product(f)(a + 1, b)
}

product(x=>x)(1, 3)

// 2 write factorical in terms of product
def factorial(n: Int) = product(x => x)(1, n)
factorial(4)

// 3 generalize both functions
def mapReduce(f: Int => Int, combine: (Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if (a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def prod(f: Int => Int) (a: Int, b: Int): Int =
  mapReduce(f, (x, y) => x * y, 1)(a, b)

prod(x=>x)(1, 4)