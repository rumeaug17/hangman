package org.rg.hangman

import java.io.IOException

import zio.*
import zio.Console.*
import zio.Random.*

import Domain.*
import Dictionary.*

def getUserInput(message: String): ZIO[Console, IOException, String] =
  printLine(message) *> readLine

object Hangman extends ZIOAppDefault:
  lazy val getName: ZIO[Console, IOException, Name] =
    for
      input <- getUserInput("What's your name?")
      name  <- ZIO.fromOption(Name.make(input)) <> (printLine("Invalid input. Please try again...") *> getName)
    yield name

  lazy val chooseWord: URIO[Random, Word] =
    for
      index <- nextIntBounded(words.length)
      word  <- ZIO.fromOption(words.lift(index).flatMap(Word.make)).orDieWith(_ => new Error("Boom!"))
    yield word

  def run: ZIO[Any, Any, Any] = ???

