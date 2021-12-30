package org.rg.hangman

object Domain:

  opaque type Name = String
  object Name:
    def make(n : String) : Option[Name] =
      if n.isEmpty then None
      else Some(n)
  extension (s : Name)
    def name : String = s

  opaque type Guess = Char
  object Guess:
    def make(s : String) : Option[Guess] =
      Some(s.toList).collect {
        case c :: Nil if c.isLetter => c.toLower
      }
  extension (c : Guess)
    def char : Char = c

  opaque type Word = String
  object Word:
    def make(w : String) : Option[Word] =
      if w.nonEmpty && w.forall(_.isLetter) then
        Some(w.toLowerCase)
      else
        None
  extension (w : Word)
    def word : String = w
    def contains(c : Char) = w.contains(c)
    def length : Int = w.length
    def list : List[Char] = w.toList
    def set : Set[Char] = w.toSet

  enum GuessResult :
    case Won, Lost, Correct, Incorrect, Unchanged

end Domain