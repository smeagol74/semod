package ru.kvb74.semod.opengroup.archimate.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{MeaningElement, MeaningElementProps, MeaningElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.MotivationLayer

case class Meaning(
	name: String
) extends MotivationLayer
	with MeaningElement {

	case class MeaningRelationships(
		override private[semod] implicit val tt: Meaning = Meaning.this
	) extends MeaningElementRelationships[Meaning]

	val rel: MeaningRelationships = MeaningRelationships()

	case class MeaningProps(
		override private[semod] implicit val tt: Meaning = Meaning.this
	) extends MeaningElementProps[Meaning]

	val prop: MeaningProps = MeaningProps()

	_registerPrefix("MM")
}
