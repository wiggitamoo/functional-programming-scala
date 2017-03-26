// implement init as external function analogous to last
def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

// implement concat
def concat[T](xs: List[T], ys: List[T]): List[T] = {
  case List() => ys
  case z :: zs => z :: concat(zs, ys)
}

// implement reverse
def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ++ List(y)
}

// the complexity of reverse is N * N

def removeAt[T](n: Int, xs: List[T]) = (xs take n) ::: (xs drop n + 1)

removeAt(1, List('a', 'b', 'c', 'd')) // List(a, c, d)

def flatten(xs: List[Any]): List[Any] = ???

flatten(List(List(1, 1), 2, List(3, List(5, 8)))) // List (1, 1, 2, 3, 5, 8)