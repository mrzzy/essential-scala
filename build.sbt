/*
 * essential-scala
 * sbt build
*/

ThisBuild / scalaVersion := "2.13.4"
ThisBuild / version      := "0.1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .settings(
    name := "essential-scala",
    libraryDependencies += "org.scalatest" %% "scalatest-flatspec" % "3.2.9" % "test"
  )
