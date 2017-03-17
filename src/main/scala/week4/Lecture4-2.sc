// Lecture 4.2: FUnctions as Objects

// Functions are treated like objects in Scala
// A => B is equivalent to
trait Function1[A, B] {
  def apply(x: A): B
}


// anonymous function
// each of these are equivalent
(x: Int) => x * x

class AnonFun extends Function1[Int, Int] {
  def apply(x: Int) = x * x
}
new AnonFun

new Function1[Int, Int] {
  def apply(x: Int) = x * x
}


// function calls
// these two functions (f & g) are equivalent
val f = (x: Int) => x * x
f(7)

val g = new Function1[Int, Int] {
  def apply(x: Int) = x * x
}
g.apply(7)


// eta-expansion
trait List[T] {
  def isEmpty: Boolean
  def head: T
  def tail: List[T]
}

class Cons[T](val head: T, val tail: List[T]) extends List[T] {
  def isEmpty = false
}

class Nil[T] extends List[T] {
  def isEmpty = true
  def head: Nothing = throw new NoSuchElementException("Nil.head")
  def tail: Nothing = throw new NoSuchElementException("Nil.tail")
}

object List {
  def apply[T](x1: T, x2: T): List[T] = new Cons(x1, new Cons(x2, new Nil))
  def apply[T]() = new Nil
}