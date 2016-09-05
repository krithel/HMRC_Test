name := "HMRC_Test"

version := "1.0"

scalaVersion := "2.11.8"

mainClass in (Compile,run) := Some("Shop")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.0"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

logBuffered in Test := false