package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{MeaningElement, MeaningElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Motivation

case class Meaning(
	name: String,
	desc: String = ""
) extends Motivation
	with MeaningElement {

	case class MeaningRelationships(
		override private[semod] implicit val tt: Meaning = Meaning.this
	) extends MeaningElementRelationships[Meaning]

	val rel: MeaningRelationships = MeaningRelationships()

	_registerPrefix("MM")
}
