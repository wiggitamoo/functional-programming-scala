// Lecture 6.2 - Combinatorial Search and For-Expressions

def scalarProduct(xs: List[Double], ys: List[Double]): Double =
  (for((x,y) <- xs zip ys) yield x * y).sum


val a:List[Double] = List(1,2,3)
val b:List[Double] = List(1,2,1)
scalarProduct(a, b)
