//Lecture 4.4 - Variance (Optional)

trait Expr {
  def isNumber: Boolean
  def isSum: Boolean
  def numValue: Int
  def leftOp: Expr
  def rightOp: Expr
}

class Number(n: Int) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue: Int = n
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr = throw new Error("Number.rightOp")
}

class Sum(ei: Expr, e2: Expr) extends Expr {
  def isNumber: Boolean = true
  def isSum: Boolean = false
  def numValue: Int = throw new Error("Sum.numValue")
  def leftOp: Expr = throw new Error("Number.leftOp")
  def rightOp: Expr =
}