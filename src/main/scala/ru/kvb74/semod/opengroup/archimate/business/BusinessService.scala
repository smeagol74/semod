package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessServiceElement, BusinessServiceElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessService(
	name: String,
	desc: String = ""
) extends BusinessLayer
	with BusinessServiceElement {

	case class BusinessServiceRelationships(
		override private[semod] implicit val tt: BusinessService = BusinessService.this
	) extends BusinessServiceElementRelationships[BusinessService]

	val rel: BusinessServiceRelationships = BusinessServiceRelationships()

	_registerPrefix("BS")
}
