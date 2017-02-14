// Lecture 2.1: Higher-Order Functions

// special cases of sums
def id(a: Int): Int = a
def sumInts(a: Int, b: Int): Int =
  if (a > b) 0 else a + sumInts(a + 1, b)
sumInts(1, 3)

def cube(x: Int): Int = x * x * x

def sumCubes(a: Int, b: Int): Int =
  if (a > b) 0 else cube(a) + sumCubes(a + 1, b)

sumCubes(1, 3)

// factorials
def factorial(a: Int): Int =
  if (a == 0) 1 else a * factorial(a - 1)
def sumFactorials(a: Int, b: Int): Int =
  if (a > b) 0 else factorial(a) + sumFactorials(a + 1, b)
sumFactorials(1, 3)


// generalize with higher order function
def sum(f: Int => Int, a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sum(f, a + 1, b)

def sumInts2(a: Int, b: Int) = sum(id, a, b)
def sumCubes2(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials2(a: Int, b: Int) = sum(factorial, a, b)

sumInts(1, 3) == sumInts2(1, 3)
sumCubes(1, 3) == sumCubes2(1, 3)
sumFactorials(1, 3) == sumFactorials2(1, 3)

// the sum pattern was reused

// anonymous functions, syntactic sugar
(x: Int) => x * x * x

def sumInts3(a: Int, b: Int) = sum(x => x, a, b)
sumInts(1, 3) == sumInts3(1, 3)