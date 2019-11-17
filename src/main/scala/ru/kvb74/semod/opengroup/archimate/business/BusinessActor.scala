package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessActorElement, BusinessActorElementProps, BusinessActorElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessActor(
	name: String
) extends BusinessLayer
	with BusinessActorElement {

	case class BusinessActorRelationships(
		override private[semod] implicit val tt: BusinessActor = BusinessActor.this
	) extends BusinessActorElementRelationships[BusinessActor]

	val rel: BusinessActorRelationships = BusinessActorRelationships()

	case class BusinessActorProps(
		override private[semod] implicit val tt: BusinessActor = BusinessActor.this
	) extends BusinessActorElementProps[BusinessActor]

	val prop: BusinessActorProps = BusinessActorProps()

	_registerPrefix("BA")
}
