package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessObjectElement, BusinessObjectElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Business

case class BusinessObject(
	name: String,
	desc: String = ""
) extends Business
	with BusinessObjectElement {

	case class BusinessObjectRelationships(
		override private[archimate] implicit val tt: BusinessObject = BusinessObject.this
	) extends BusinessObjectElementRelationships[BusinessObject]

	val rel: BusinessObjectRelationships = BusinessObjectRelationships()

}
