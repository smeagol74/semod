package org.opengroup.archimate

import org.opengroup.archimate.meta.element.Element
import org.opengroup.archimate.meta.relationship.Relationship
import org.opengroup.archimate.report.PlantUmlReportingEngine

import scala.collection.mutable

trait ReportingEngineOptions {
	val name: Option[String]
	val title: Option[String]
	val header: Option[String]
	val footer: Option[String]
}

trait ReportingEngine {

	def renderToString(
		options: ReportingEngineOptions,
		elements: Set[Element],
		relationships: Set[Relationship]
	): String

	def renderToSvg(
		file: String,
		options: ReportingEngineOptions,
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

	class OptionsBuilder {
		private var _name: Option[String] = None
		private var _title: Option[String] = None
		private var _header: Option[String] = None
		private var _footer: Option[String] = None

		def name(value: String): OptionsBuilder = {
			_name = Some(value)
			this
		}

		def title(value: String): OptionsBuilder = {
			_title = Some(value)
			this
		}

		def header(value: String): OptionsBuilder = {
			_header = Some(value)
			this
		}

		def footer(value: String): OptionsBuilder = {
			_footer = Some(value)
			this
		}

		def get: ReportingEngineOptions = Options(_name, _title, _header, _footer)
	}

	case class Options(
		name: Option[String],
		title: Option[String],
		header: Option[String],
		footer: Option[String]
	) extends ReportingEngineOptions

	object Options {
		def empty = new OptionsBuilder
	}

	def withDependencies(options: ReportingEngineOptions, elements: Element*): String = {
		val deps = _getAllDependencies(elements.toSet)
		val rels = mutable.Set.empty[Relationship]
		deps.foreach(el => {
			rels ++= el._relationships
		})
		engine.renderToString(options, deps, rels.toSet)
	}
}
