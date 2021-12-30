package org.rg.hangman

import Domain.*

case class GameState private(name : Name, guesses : Set[Guess], word : Word) :
  def failuresCount : Int = (guesses.map(_.char) -- word.set).size
  def isPlayerLost : Boolean = failuresCount > 5
  def isPlayerWon : Boolean = (word.set -- guesses.map(_.char)).isEmpty

  def addGuess(guess : Guess) : GameState = new GameState(name, guesses + guess, word)

end GameState

object GameState:
  def initial(name : Name, word : Word) : GameState = new GameState(name, Set.empty, word)
