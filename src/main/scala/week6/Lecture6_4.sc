// Lecture 6.4 - Maps

val romanNumerals = Map("I" -> 1, "V" -> 5, "X" -> 10)
val capitalsOfCountry = Map("US" -> "Washington","Switzerland" -> "Bern")

capitalsOfCountry("US")
capitalsOfCountry get "US"
capitalsOfCountry get "Andora"

def showCapital(country: String) = capitalsOfCountry.get(country) match {
  case Some(capital) => capital
  case None => "Missing capital"
}

showCapital("US")
showCapital("Andora")

// option type
// Some(x): can be get,

Map(0 -> 5, 1 -> -2, 3 -> 1)

// express polynomial as map
class Poly(val terms0: Map[Int, Double]) {
  def this(bindings: (Int, Double)*) = this(bindings.toMap)
  val terms = terms0 withDefaultValue 0.0
//  def  + (other: Poly) = new Poly(terms ++ other.terms map adjust)
  def  + (other: Poly) = new Poly((other.terms foldLeft terms)(addTerm))
  def addTerm(terms: Map[Int, Double], term: (Int, Double)): Map[Int, Double] = {
    val (exp, coeff) = term
//    terms get exp match {
//      case Some(coeff1) => exp -> (coeff + coeff1)
//      case None => exp -> coeff
//    }
    terms + (exp -> (coeff + terms(exp)))
  }
  override def toString =
    (for((exp, coeff) <- terms.toList.sorted.reverse) yield {
      if(exp > 1) coeff+" x^"+exp
      else if (exp == 1) coeff+" x"
      else coeff
    }) mkString " + "
}

//val p1 = new Poly(Map(1 -> 2.0, 3 -> 4.0, 5 -> 6.2))
//val p2 = new Poly(Map(0 -> 3.0, 3 -> 7.0))
val p1 = new Poly(1 -> 2.0, 3 -> 4.0, 5 -> 6.2)
val p2 = new Poly(0 -> 3.0, 3 -> 7.0)
p1+p2

p1.terms(7)

// simpler way
val cap1 = capitalsOfCountry withDefaultValue "<unknown>"
cap1("US")
cap1("Al")