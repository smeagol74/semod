# System Engineer Modelling DSL for Scala
This project is Proof Of Concept only and not for production usage yet

## Current Capabilities
* Implemented almost the whole of the [Archimate 3.0.1 specifications][archimate] (all elements and relationships)
* Implemented diagramming with automatic layout using [PlantUML][puml]

## Known Issues
Archimate 3.0.1 suppose the association relationship between elements and relationships

## Prerequisites
To be able to work with this DSL you will need to have installed on your computer:
* [Java (JDK-12)][jdk] (probably 1.8 will work also, but not tested)
* [Scala Build Tool (sbt)][sbt]

## Usage
The easiest way to try the DSL is to use the [smeagol74/semod.g8][g8] Gitter8 template to generate the project boilerplate with command
```shell script
$ sbt new smeagol74/semod.g8
```

[More documentation][pages]

[archimate]: http://pubs.opengroup.org/architecture/archimate3-doc/toc.html
[sbt]: https://www.scala-sbt.org/
[jdk]: https://jdk.java.net/12/
[g8]: https://github.com/smeagol74/semod.g8
[puml]: http://plantuml.com/
[pages]: https://smeagol74.github.io/semod/