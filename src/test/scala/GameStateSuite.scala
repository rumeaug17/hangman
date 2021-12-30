package org.rg.hangman

import org.scalatest.funsuite.AnyFunSuite
import Domain.*

class GameStateSuite extends AnyFunSuite:

  val name: Name = Name.make("Guillaume").get
  val word: Word = Word.make("Découverte").get
  val init: GameState = GameState.initial(name, word)

  test("Valid initial GameState") {
    assert(init.failuresCount == 0)
    assert(!init.isPlayerLost)
    assert(!init.isPlayerWon)
  }

  test("Valid second GameState") {
    val second = init.addGuess(Guess.make("x").get).addGuess(Guess.make("r").get)
    assert(init.failuresCount == 0)
    assert(!init.isPlayerLost)
    assert(!init.isPlayerWon)
    assert(second.failuresCount == 1)
    assert(!second.isPlayerLost)
    assert(!second.isPlayerWon)
  }