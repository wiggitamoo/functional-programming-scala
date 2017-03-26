// Lecture 6.1 - Other Collections

// use vectors for bulk operations such as map fold or filter

// use lists for recursive operations using head and tail

def a = Array(2,3)
a map (x => x * 2)

val b = "Andre Henriques"
b filter(c => c.isUpper)

b exists (c => c.isUpper) // true
b forall (c => c.isUpper) // false

val r: Range = 1 until 5
val s: Range = 1 to 5

val pairs = List(1,2,3) zip b
val (num, alpha) = pairs.unzip

val M = 3
val N = 2
(1 to M) flatMap (x => (1 to N) map (y => (x, y)))

def isPrime(n: Int): Boolean =
  (2 to n-1) forall (c => n%c != 0)

isPrime(11)
