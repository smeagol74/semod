package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessObjectElement, BusinessObjectElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessObject(
	name: String,
	desc: String = ""
) extends BusinessLayer
	with BusinessObjectElement {

	case class BusinessObjectRelationships(
		override private[semod] implicit val tt: BusinessObject = BusinessObject.this
	) extends BusinessObjectElementRelationships[BusinessObject]

	val rel: BusinessObjectRelationships = BusinessObjectRelationships()

	_registerPrefix("BO")
}
