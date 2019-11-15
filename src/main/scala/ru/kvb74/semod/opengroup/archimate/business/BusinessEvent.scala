package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessEventElement, BusinessEventElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessEvent(
	name: String,
	desc: String = ""
) extends BusinessLayer
	with BusinessEventElement {

	case class BusinessEventRelationships(
		override private[semod] implicit val tt: BusinessEvent = BusinessEvent.this
	) extends BusinessEventElementRelationships[BusinessEvent]

	val rel: BusinessEventRelationships = BusinessEventRelationships()

	_registerPrefix("BE")
}
