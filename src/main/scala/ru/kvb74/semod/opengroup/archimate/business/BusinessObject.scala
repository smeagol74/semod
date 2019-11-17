package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessObjectElement, BusinessObjectElementProps, BusinessObjectElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessObject(
	name: String
) extends BusinessLayer
	with BusinessObjectElement {

	case class BusinessObjectRelationships(
		override private[semod] implicit val tt: BusinessObject = BusinessObject.this
	) extends BusinessObjectElementRelationships[BusinessObject]

	val rel: BusinessObjectRelationships = BusinessObjectRelationships()

	case class BusinessObjectProps(
		override private[semod] implicit val tt: BusinessObject = BusinessObject.this
	) extends BusinessObjectElementProps[BusinessObject]

	val prop: BusinessObjectProps = BusinessObjectProps()

	_registerPrefix("BO")
}
