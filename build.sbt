scalaVersion := "2.12.8"

unmanagedBase := file("./lib")

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5" % "test"
libraryDependencies += "com.plantuml" % "plantuml" % "1.2019.7" from "file://./lib/plantuml-1.2019.7-SNAPSHOT.jar"





