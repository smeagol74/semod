package org.opengroup.archimate.report

import org.opengroup.archimate.{ReportingEngine, Resource}
import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.layer.Layer
import org.opengroup.archimate.meta.relationship.Relationship
import org.opengroup.archimate.relationship.dependency.Influence

import scala.compat.Platform.EOL

object PlantUmlReportingEngine extends ReportingEngine {

	private def _normalize(text: String): String = text.replaceAll("\n", "\\\\n")

	private def renderElement(element: Element): String = {
		val sb = StringBuilder.newBuilder
		val kind = Resource.b.getString(element.fullElementName)
		element match {
			case layer: Layer =>
				sb.append(layer.layerName)
				sb.append("_")
				sb.append(element.elementName.replaceFirst(layer.layerName, ""))
			case _ =>
				sb.append(element.elementName)
		}
		sb.append(s"""(${element.id}, "${_normalize(element.name)}""")
		if (element.name.nonEmpty) {
			sb.append("\\n")
		}
		sb.append(s"""($kind)")""")
		sb.mkString
	}

	private def _renderInfluence(relationship: Influence): String = {
		val sb = StringBuilder.newBuilder
		val name = s"Rel_${relationship.asInstanceOf[Product].productPrefix}"
		val desc = Resource.b.getString(if (relationship.direct) name else s"${name}_back")
		val label = if (relationship.label.isEmpty) "" else s" (${relationship.label})"
		sb.append(name)
		sb.append(s"""(${relationship.src.id}, ${relationship.dst.id}, "$desc$label")""")
		sb.mkString
	}

	private def _renderGeneric(relationship: Relationship): String = {
		val sb = StringBuilder.newBuilder
		val name = s"Rel_${relationship.asInstanceOf[Product].productPrefix}"
		val desc = Resource.b.getString(if (relationship.direct) name else s"${name}_back")
		sb.append(name)
		sb.append(s"""(${relationship.src.id}, ${relationship.dst.id}, "$desc")""")
		sb.mkString
	}

	private def renderRelationship(relationship: Relationship): String = relationship match {
		case rel: Influence => _renderInfluence(rel)
		case _ => _renderGeneric(relationship)
	}

	override def renderToSvg(
		file: String,
		title: Option[String],
		elements: Set[Element],
		relationships: Set[Relationship]
	): Unit = {

	}

	override def renderToString(
		title: Option[String],
		elements: Set[Element],
		relationships: Set[Relationship]
	): String = {

		val sb = StringBuilder.newBuilder
		sb.append("@startuml").append(EOL)
		sb.append("!includeurl https://raw.githubusercontent.com/smeagol74/Archimate-PlantUML/master/Archimate.puml").append(EOL).append(EOL)

		title match {
			case Some(titl) =>
				sb.append(s"title ${_normalize(titl)}").append(EOL).append(EOL)
			case None =>
		}

		elements.map(renderElement).foreach(sb.append(_).append(EOL))
		relationships.map(renderRelationship).foreach(sb.append(_).append(EOL))

		sb.append("@enduml").append(EOL)
		sb.mkString
	}
}
