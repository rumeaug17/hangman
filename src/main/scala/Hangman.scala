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

  def getGuess: ZIO[Console, IOException, Guess] =
    for
      input <- getUserInput("What's your next guess?")
      guess <- ZIO.fromOption(Guess.make(input)) <> (printLine("Invalid input. Please try again...") *> getGuess)
    yield guess

  def renderState(state: GameState): ZIO[Console, IOException, Unit] =
    val hangman = ZIO.attempt(hangmanStages(state.failuresCount)).orDieWith(_ => new Error("Boom!"))
    val word =
      state.word.list
        .map(c => if (state.guesses.map(_.char).contains(c)) s" $c " else "   ")
        .mkString
    val line    = List.fill(state.word.length)(" - ").mkString
    val guesses = s" Guesses: ${state.guesses.map(_.char).mkString(", ")}"
    hangman.flatMap { (h : String) =>
      printLine(
        s"""
           #$h
           #
           #$word
           #$line
           #
           #$guesses
           #
           #""".stripMargin('#')
      )
    }

  def gameLoop(oldState: GameState): ZIO[Console, IOException, Unit] =
    for
      guess <- renderState(oldState) *> getGuess
      newState = oldState.addGuess(guess)
      guessResult = oldState.result(guess, newState)
      _ <- guessResult match
        case GuessResult.Won => printLine(s"Congratulations ${newState.name.name}! You won!") *> renderState(newState)
        case GuessResult.Lost => printLine(s"Sorry ${newState.name.name}! You lost! Word was: ${newState.word.word}") *> renderState(newState)
        case GuessResult.Correct => printLine(s"Good guess, ${newState.name.name}!") *> gameLoop(newState)
        case GuessResult.Incorrect => printLine(s"Bad guess, ${newState.name.name}!") *> gameLoop(newState)
        case GuessResult.Unchanged => printLine(s"${newState.name.name}, You've already tried that letter!") *> gameLoop(newState)
    yield ()

  def run: URIO[Console with Random, ExitCode] =
    (for
      name <- printLine("Welcome to ZIO Hangman!") *> getName
      word <- chooseWord
      _    <- gameLoop(GameState.initial(name, word))
    yield ()).exitCode

