package ru.kvb74.semod.omg.essence.essence

import ru.kvb74.semod.omg.essence.meta.element.{PracticeElement, PracticeElementProps, PracticeElementRelationships}
import ru.kvb74.semod.omg.essence.meta.layer.{AreaOfConcern, EssenceLayer}

case class Practice(
	areaOfConcern: AreaOfConcern.Value,
	name: String
) extends EssenceLayer
	with PracticeElement {

	case class PracticeRelationships(
		override private[semod] implicit val tt: Practice = Practice.this
	) extends PracticeElementRelationships[Practice]

	val rel: PracticeRelationships = PracticeRelationships()

	case class PracticeProps(
		override private[semod] implicit val tt: Practice = Practice.this
	) extends PracticeElementProps[Practice]

	val prop: PracticeProps = PracticeProps()

	_registerPrefix("EPr")

}

