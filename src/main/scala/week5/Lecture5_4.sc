// Lecture 5.4 - Higher-Order List Functions

def scaleList(xs: List[Double], factor: Double) =
  xs map (x => x * factor)


// return squares of list (map)
def squareList1(xs: List[Int]): List[Int] =
  xs match {
    case Nil => xs
    case y :: ys => y * y :: squareList1(ys)
  }

def squareList2(xs: List[Int]): List[Int] =
  xs map (x => x * x)

val nums = List(1,2,3,4)
squareList1(nums)
squareList2(nums)


// return positive elements (filter)
def posElems1(xs: List[Int]): List[Int] = xs match {
  case Nil => xs
  case y :: ys => if(y>0) y :: posElems1(ys) else posElems1(ys)
}

def posElems2(xs: List[Int]): List[Int] =
  xs filter(x => x > 0)

val nums2 = List(1,-2,-3,4)
posElems1(nums2)
posElems2(nums2)

// filter
// filterNot
// partition
// takeWhile
// dropWhile
// span

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: xs1 =>
    val (first, rest) = xs span (y => y == x)
    first :: pack(rest)
}


pack(List("a", "a", "a", "b", "c", "c", "a"))

def encode[T](xs: List[T]): List[(T, Int)] =
    pack(xs) map (ys => (ys.head, ys.length))

encode(List("a", "a", "a", "b", "c", "c", "a"))