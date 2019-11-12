package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessFunctionElement, BusinessFunctionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Business

case class BusinessFunction(
	name: String,
	desc: String = ""
) extends Business
	with BusinessFunctionElement {

	case class BusinessFunctionRelationships(
		override private[semod] implicit val tt: BusinessFunction = BusinessFunction.this
	) extends BusinessFunctionElementRelationships[BusinessFunction]

	val rel: BusinessFunctionRelationships = BusinessFunctionRelationships()

	_registerPrefix("BF")
}
