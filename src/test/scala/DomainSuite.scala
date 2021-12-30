package org.rg.hangman

import org.scalatest.funsuite.AnyFunSuite
import Domain.*

class DomainSuite extends AnyFunSuite:
  test("Valid Name construct") {
    assert(Name.make("Guillaume").get.name.nonEmpty)
  }

  test("Invalid Name safe construct") {
    assert(Name.make("").isEmpty)
  }

  test("Valid Guess construct") {
    assert(Guess.make("R").get.char == 'r')
  }

  test("Invalid Guess safe construct") {
    assert(Guess.make("").isEmpty)
    assert(Guess.make("long").isEmpty)
  }

  test("Word Guess construct") {
    val w : Word = Word.make("Découverte").get
    assert(w.word == "découverte")
    assert(w.contains('t'))
    assert(w.length == 10)
  }

  test("Invalid Word safe construct") {
    assert(Word.make("").isEmpty)
    assert(Word.make("Découvert3").isEmpty)
  }