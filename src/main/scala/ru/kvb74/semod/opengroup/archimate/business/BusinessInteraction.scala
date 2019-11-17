package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessInteractionElement, BusinessInteractionElementProps, BusinessInteractionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessInteraction(
	name: String
) extends BusinessLayer
	with BusinessInteractionElement {

	case class BusinessInteractionRelationships(
		override private[semod] implicit val tt: BusinessInteraction = BusinessInteraction.this
	) extends BusinessInteractionElementRelationships[BusinessInteraction]

	val rel: BusinessInteractionRelationships = BusinessInteractionRelationships()

	case class BusinessInteractionProps(
		override private[semod] implicit val tt: BusinessInteraction = BusinessInteraction.this
	) extends BusinessInteractionElementProps[BusinessInteraction]

	val prop: BusinessInteractionProps = BusinessInteractionProps()

	_registerPrefix("BI")
}
