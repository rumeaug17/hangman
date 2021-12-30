ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.1.0"

ThisBuild / libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.0-RC1",
  "org.scalactic" %% "scalactic" % "3.2.10",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test"
)

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)

lazy val root = (project in file("."))
  .settings(
    name := "hangman",
    idePackagePrefix := Some("org.rg.hangman")
  )
