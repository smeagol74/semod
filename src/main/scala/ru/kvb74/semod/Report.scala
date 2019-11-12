package ru.kvb74.semod

import ru.kvb74.semod.meta.{Element, Relationship}

import scala.collection.mutable

trait Report {
	val elements: Set[Element]
	val relationships: Set[Relationship]
}

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

	case class ReportInstance(
		elements: Set[Element],
		relationships: Set[Relationship]
	) extends Report

	def withDependencies(elements: Element*): Report = {
		val deps = _getAllDependencies(elements.toSet)
		val rels = mutable.Set.empty[Relationship]
		deps.foreach(el => {
			rels ++= el._relationships
		})
		ReportInstance(
			deps,
			rels.toSet
		)
	}
}
