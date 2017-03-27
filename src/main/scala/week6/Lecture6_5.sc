import scala.io.Source
// Lecture 6.5 - Putting the Pieces Together

val mnem = Map (
'2' -> "ABC", '3' -> "DEF", '4' -> "GHI", '5' -> "JKL", '6' -> "MNO", '7' -> "PQRS", '8' -> "TUV", '9' -> "WXYZ")

val in = Source.fromURL("http://lamp.epfl.ch/files/content/sites/lamp/files/teaching/progfun/linuxwords.txt")

val words = in.getLines.toList filter (word => word forall (chr => chr.isLetter))

// invert the mnem map to give a map from chart A-Z and 2-9
val charCode: Map[Char, Char] =
  for((digit, str) <- mnem; ltr <- str) yield ltr -> digit

// maps a word to the dieit string it can represent
def wordCode(word: String) : String =
  word.toUpperCase() map charCode
wordCode("JAVA")
wordCode("Java")

// map digit strings to words that represent them
// a missing number shoul dmap to the empty set
val wordsForNum: Map[String, Seq[String]] =
  words groupBy wordCode withDefaultValue Seq()


// return all ways to encode a number
def encode(number: String): Set[List[String]] =
  if(number.isEmpty) Set(List())
  else {
    for {
      split <- 1 to number.length
      word <- wordsForNum(number take split)
      rest <- encode(number drop split)
    } yield word :: rest
  }.toSet

encode("7225247386")

def translate(number: String): Set[String] =
encode(number) map (_ mkString " ")

translate("7225247386")