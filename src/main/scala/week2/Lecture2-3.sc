// Lecture 2.3 - Example: Finding Fixed Points

import math.abs

// a fixed point is where f(x) = x
val tolerance = 0.0001
def isCloseEnough(x: Double, y: Double) =
  abs((x-y)/x) / x < tolerance


isCloseEnough(1,2)
isCloseEnough(1,1.0001)

def fixedPoint(f: Double => Double)(firstGuess: Double) = {
  def iterate(guess: Double): Double = {
    val next = f(guess)
    if(isCloseEnough(guess, next)) next
    else iterate(next)
  }
  iterate(firstGuess)
}

fixedPoint(x => 1 + x / 2)(1) // should be close to 2


// a square root is just a fixed point where y = x/y
/* proof
 * y = sqrt(x)
 * y * y = x
 * y = x / y
 * y is the sqrt of x when an input of y to x/y returns y as a result
 */
def sqrt(x:Double) = fixedPoint( y => (y + x /y) /2 )(2)
sqrt(2)

def averageDamp(f:Double => Double)(x: Double) = (x + f(x)) / 2

def srt(x:Double) = fixedPoint(averageDamp(y => x / y))(1)
srt(2)