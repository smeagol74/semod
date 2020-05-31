package ru.kvb74.semod

import ru.kvb74.semod.meta.{Element, Relationship}

import scala.collection.mutable

trait Report {
	val elements: Set[Element]
	val relationships: Set[Relationship]
}

object Report {

	case class ReportInstance(
		elements: Set[Element],
		relationships: Set[Relationship]
	) extends Report

	def apply(elements: Set[Element]): Report = {
		val rels = mutable.Set.empty[Relationship]
		elements.foreach(el => {
			rels ++= el._relationships.filter(rel => elements.contains(rel.dst))
		})
		ReportInstance(
			elements,
			rels.toSet
		)
	}

	def apply(elements: Element*): Report = {
		apply(elements.toSet)
	}

}
