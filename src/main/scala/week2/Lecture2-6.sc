//Lecture 2.6: More Fun with Rational

val x = new Rational(1, 3)
val y = new Rational(5, 8)
val z = new Rational(10, 4)
x.numer
x.denom
x.sub(y).sub(z)
y.add(y)
x.less(y)
x.max(y)
y.max(x)

val a = new Rational(2)

val strange = new Rational(1, 0)
strange.add(strange)



class Rational(x: Int, y: Int) {
  // irrational numbers need to be handled
  require(y != 0, "denominator must be non-zero")

  def this(x: Int) = this(x, 1)

  private def gcd(a: Int, b: Int): Int = if (b == 0) a else gcd(b, a % b)

  def numer = x / gcd(x, y)
  def denom = y / gcd(x, y)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this

  def add(that: Rational) =
    new Rational(
      numer * that.denom + that.numer * denom,
      denom * that.denom
    )

  def neg: Rational = new Rational(-numer, denom)
  def sub(that: Rational) = add(that.neg)

  override def toString = numer + "/" + denom
}



