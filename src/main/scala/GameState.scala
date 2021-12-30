package org.rg.hangman

import Domain.*

case class GameState private(name : Name, guesses : Set[Guess], word : Word) :
  def failuresCount : Int = (guesses.map(_.char) -- word.set).size
  def isPlayerLost : Boolean = failuresCount > 5
  def isPlayerWon : Boolean = (word.set -- guesses.map(_.char)).isEmpty

  def addGuess(guess : Guess) : GameState = new GameState(name, guesses + guess, word)

  def result(guess : Guess, newGameState : GameState) : GuessResult =
    if guesses.contains(guess) then GuessResult.Unchanged
    else
      if newGameState.isPlayerWon then GuessResult.Won
      else if newGameState.isPlayerLost then GuessResult.Lost
      else if word.contains(guess.char) then GuessResult.Correct
      else
        GuessResult.Incorrect

end GameState

object GameState:
  def initial(name : Name, word : Word) : GameState = new GameState(name, Set.empty, word)
