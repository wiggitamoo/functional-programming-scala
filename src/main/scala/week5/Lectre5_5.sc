// Lecture 5.5 - Reduction of Lists

// combine elements of a list using an operator

def sum(xs: List[Int]): Int = xs match {
  case Nil => 0
  case y :: ys => y + sum(ys)
}

val a: List[Int] = List(1,2,3)
val b: List[Int] = List()
sum(a)

// generalize the pattern with reduceLeft

a reduceLeft ((x,y) => x + y)
a reduceLeft (_+_)
(a foldLeft 0 )(_+_)
(b foldLeft 1 )(_+_)

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]())( ??? )

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0)( _+_ )

