ThisBuild / version := "1.0.0"

maintainer := "rumeaug17@gmail.com"

ThisBuild / scalaVersion := "3.1.0"

ThisBuild / libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "2.0.0-RC1",
  "org.scalactic" %% "scalactic" % "3.2.10",
  "org.scalatest" %% "scalatest" % "3.2.10" % "test",
  "org.rg" %% "scala-util3" % "1.0.0"
)

ThisBuild / scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)

enablePlugins(JavaAppPackaging)

lazy val root = (project in file("."))
  .settings(
    name := "hangman",
    organization := "org.rg",
    idePackagePrefix := Some("org.rg.hangman")
  )
