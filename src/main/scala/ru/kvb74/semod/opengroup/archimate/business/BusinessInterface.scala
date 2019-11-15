package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessInterfaceElement, BusinessInterfaceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessInterface(
	name: String,
	desc: String = ""
) extends BusinessLayer
	with BusinessInterfaceElement {

	case class BusinessInterfaceRelationships(
		override private[semod] implicit val tt: BusinessInterface = BusinessInterface.this
	) extends BusinessInterfaceElementRelationships[BusinessInterface]

	val rel: BusinessInterfaceRelationships = BusinessInterfaceRelationships()

	_registerPrefix("BIf")
}
