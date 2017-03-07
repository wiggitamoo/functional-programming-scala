//Lecture 2.7: More Fun with Rational

val x = new Rational(1, 3)
val y = new Rational(5, 8)
val z = new Rational(10, 4)
x.numer
x.denom
x - y - z
y + y
y + y
x < y
x.max(y)
y.max(x)
-y

val a = new Rational(2)

val strange = new Rational(1, 0)
strange + strange



class Rational(x: Int, y: Int) {
  // irrational numbers need to be handled
  require(y != 0, "denominator must be non-zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this

  def + (that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def unary_- : Rational = new Rational(-numer, denom)
  def - (that: Rational) = this + -that

  override def toString = numer + "/" + denom
}



