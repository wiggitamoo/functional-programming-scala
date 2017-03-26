// Lecture 5.2 - Pairs and Tuples

// Sort faster
// Merge Sort
def msort_old(xs: List[Int]): List[Int] = {
  val n = xs.length/2
  if (n == 0 ) xs else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] = {
      xs match {
        case Nil => ys
        case x :: xs1 => ys match {
          case Nil => xs
          case y :: ys1 =>
            if(x < y) x :: merge(xs1, ys)
            else y :: merge(xs, ys1)
        }
      }
    }
    val(fst, snd) = xs splitAt(n)
    merge(msort(fst), msort(snd))
  }
}

// pair
val pair = ("answer", 42)

val (label, value) = pair


def msort(xs: List[Int]): List[Int] = {
  val n = xs.length/2
  if (n == 0 ) xs else {
    def merge(xs: List[Int], ys: List[Int]): List[Int] =
      (xs, ys) match {
        case(Nil, ys) => ys
        case (xs, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if( x < y) x :: merge (xs1, ys)
          else y:: merge(xs, ys1)
      }
    val(fst, snd) = xs splitAt(n)
    merge(msort(fst), msort(snd))
  }
}

def nums = List(1,5,-4,3)
msort_old(nums)
msort(nums)