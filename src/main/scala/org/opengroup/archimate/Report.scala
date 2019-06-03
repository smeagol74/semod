package org.opengroup.archimate

import org.opengroup.archimate.meta.element.Element

import scala.collection.mutable
import scala.compat.Platform.EOL

object Report {

	

	private def _getAllDependencies(elements: Set[Element]): Set[Element] = {
		val res = mutable.HashSet.empty[Element]
		res ++= elements

		elements.foreach(el => res ++= el.relatedElements)

		if (res.size != elements.size)
			_getAllDependencies(res.toSet)
		else
			res.toSet
	}

	def withDependencies(elements: Set[Element]): String = {
		val sb = StringBuilder.newBuilder
		val deps = _getAllDependencies(elements)
		sb.append("@startuml").append(EOL)
		sb.append("!includeurl https://raw.githubusercontent.com/smeagol74/Archimate-PlantUML/master/Archimate.puml").append(EOL)

		deps.foreach(el => {
			sb.append(el.puml.element).append(EOL)
		})
		deps.foreach(el => {
			sb.append(el.puml.relationships).append(EOL)
		})
		sb.append("@enduml").append(EOL)
		sb.mkString
	}
}
