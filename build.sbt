ThisBuild / organization := "com.example"
ThisBuild / scalaVersion := "2.13.5"

val http4sVersion = "0.23.26"

lazy val root = (project in file(".")).settings(
  name := "cats-effect-3-quick-start",
  libraryDependencies ++= Seq(
    // "core" module - IO, IOApp, schedulers
    // This pulls in the kernel and std modules automatically.
    "org.typelevel" %% "cats-effect" % "3.3.12",
    // concurrency abstractions and primitives (Concurrent, Sync, Async etc.)
    "org.typelevel" %% "cats-effect-kernel" % "3.3.12",
    // standard "effect" library (Queues, Console, Random etc.)
    "org.typelevel" %% "cats-effect-std" % "3.3.12",
    // better monadic for compiler plugin as suggested by documentation
    compilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    "org.http4s" %% "http4s-ember-client" % http4sVersion,
    "org.http4s" %% "http4s-ember-server" % http4sVersion,
    "org.http4s" %% "http4s-dsl"          % http4sVersion,
    "org.http4s" %% "http4s-circe" % http4sVersion,
    // Optional for auto-derivation of JSON codecs
    "io.circe" %% "circe-generic" % "0.14.6",
    // Optional for string interpolation to JSON model
    "io.circe" %% "circe-literal" % "0.14.6",
    "org.scalatest" %% "scalatest" % "3.2.18" % Test,
    "org.scalatestplus" %% "mockito-5-10" % "3.2.18.0" % Test,
    "org.typelevel" %% "munit-cats-effect-3" % "1.0.7" % Test
  )
)
