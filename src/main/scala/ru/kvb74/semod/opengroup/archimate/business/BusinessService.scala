package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessServiceElement, BusinessServiceElementProps, BusinessServiceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessService(
	name: String
) extends BusinessLayer
	with BusinessServiceElement {

	case class BusinessServiceRelationships(
		override private[semod] implicit val tt: BusinessService = BusinessService.this
	) extends BusinessServiceElementRelationships[BusinessService]

	val rel: BusinessServiceRelationships = BusinessServiceRelationships()

	case class BusinessServiceProps(
		override private[semod] implicit val tt: BusinessService = BusinessService.this
	) extends BusinessServiceElementProps[BusinessService]

	val prop: BusinessServiceProps = BusinessServiceProps()

	_registerPrefix("BS")
}
