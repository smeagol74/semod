package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessActorElement, BusinessActorElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Business

case class BusinessActor(
	name: String,
	desc: String = ""
) extends Business
	with BusinessActorElement {

	case class BusinessActorRelationships(
		override private[semod] implicit val tt: BusinessActor = BusinessActor.this
	) extends BusinessActorElementRelationships[BusinessActor]

	val rel: BusinessActorRelationships = BusinessActorRelationships()

	_registerPrefix("BA")
}
