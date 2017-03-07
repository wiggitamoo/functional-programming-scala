// Lecture 3.1 - Class Hierarchies

// abstract classes can contain members with their instances missing
abstract class IntSet {
  def incl(x: Int): IntSet
  def contains(x: Int): Boolean
  def union(other: IntSet): IntSet
}

// implement sets as binary trees
object Empty extends IntSet {
  def contains(x: Int): Boolean = false
  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)
  override def toString: String = "."
  override def union(other: IntSet) = other
}

class NonEmpty (elem: Int, left: IntSet, right: IntSet) extends IntSet {
  def contains(x: Int): Boolean =
    if (x < elem) left contains x
    else if (x > elem) right contains x
    else true
  def incl(x: Int): IntSet =
    if (x < elem) new NonEmpty(elem, left incl x, right)
    else if (x > elem) new NonEmpty(elem, left, right incl x)
    else this
  override def toString: String = "{" + left + elem + right + "}"
  override def union(other: IntSet) =
    ((left union right) union other) incl elem
}

// persistent data structure (changes to datastructure don't overwrite old versions of the datastructure
val t1 = new NonEmpty(1, Empty, Empty)
val t2 = t1.incl(2)

val t3a = new NonEmpty(3, Empty, Empty)
val t3b = t2 union t3a


// base class and sub classes
abstract class Base {
  def foo = 1
  def bar: Int
}

class Sub extends  Base {
  override def foo: Int = 2
  def foo2: Int = 2
  def bar = 3
}

