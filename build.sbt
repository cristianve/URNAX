name := "Votox"

version := "0.1"

scalaVersion := "2.13.6"

idePackagePrefix := Some("com.redgroup.votox")

libraryDependencies += "com.typesafe.akka" %% "akka-http" % "10.2.4"
libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.6.15"
libraryDependencies += "com.typesafe.akka" %% "akka-actor-typed" % "2.6.15"
libraryDependencies += "com.typesafe.akka" %% "akka-stream" % "2.6.15"
libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.2"

val circeVersion = "0.14.1"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)
