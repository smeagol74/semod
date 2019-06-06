package org.opengroup.archimate

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.Relationship
import org.opengroup.archimate.report.PlantUmlReportingEngine

import scala.collection.mutable

trait ReportingEngine {

	def renderToString(
		title: Option[String],
		elements: Set[Element],
		relationships: Set[Relationship]
	): String

	def renderToSvg(
		file: String,
		title: Option[String],
		elements: Set[Element],
		relationships: Set[Relationship]
	)
}

object Report {

	val engine: ReportingEngine = PlantUmlReportingEngine

	private def _getAllDependencies(elements: Set[Element]): Set[Element] = {
		val res = mutable.HashSet.empty[Element]
		res ++= elements

		elements.foreach(el => res ++= el.relatedElements)

		if (res.size != elements.size)
			_getAllDependencies(res.toSet)
		else
			res.toSet
	}

	def withDependencies(title: Option[String], elements: Set[Element]): String = {
		val deps = _getAllDependencies(elements)
		val rels = mutable.Set.empty[Relationship]
		deps.foreach(el => {
			rels ++= el._relationships
		})
		engine.renderToString(title, deps, rels.toSet)
	}
}
