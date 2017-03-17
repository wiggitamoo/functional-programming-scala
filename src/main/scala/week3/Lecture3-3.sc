import com.sun.corba.se.impl.interceptors.InterceptorList
//Lecture 3.3 - Polymorphism

/*
 *
 * Polymorphism mean having many forms
 * so a function can have many different types
 * this is done throught
 * subtyping (instances passed to base class)
 * generics (type parametization)
 *
 */

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


def singleton[T](elem: T) = new Cons[T](elem, new Nil[T])

singleton[Int](1)
singleton(1)
singleton[Boolean](true)
singleton(true)

// exercise: given n and list, select nth element of list
def nth[T](n: Int, xs: List[T]): T = {
  if(xs.isEmpty) throw new IndexOutOfBoundsException
  if (n==0) xs.head
  else nth(n-1, xs.tail)
}

val list = new Cons(1, new Cons(2, new Cons(3, new Nil)))

nth(2, list)
nth(3, list)
nth(-1, list)
nth(4, list)