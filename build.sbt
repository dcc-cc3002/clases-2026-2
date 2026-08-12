ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.8"

lazy val root = (project in file("."))
  .settings(
    name := "clases-2026-2"
  )


libraryDependencies += "org.scalameta" %% "munit" % "1.1.0" % Test
