name := """s3-stub"""

version := "1.0"

scalaVersion := "2.11.8"

resolvers += Resolver.bintrayRepo("findify", "maven")

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.1" % "test"
libraryDependencies += "io.findify" %% "s3mock" % "0.1.6"
libraryDependencies += "ch.qos.logback" % "logback-classic" % "1.2.1"


