// Lecture 4.3: Subtyping and generics

// okay for most situations
// def assertAllPos(s: IntSet): IntSet

// more precise (in-case empty or nonEmpty sets)
// def assertAllPos[S <: IntSet](r:S): S =

// <: upper bound of the type parameter S
// >: lower bound of the type parameter S

// Example usage: [S >: NonEmpty <: IntSet]
// NonEmpty is a subtype of IntSet
// these are called covariant relationships

