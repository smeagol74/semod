package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessFunctionElement, BusinessFunctionElementProps, BusinessFunctionElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessFunction(
	name: String
) extends BusinessLayer
	with BusinessFunctionElement {

	case class BusinessFunctionRelationships(
		override private[semod] implicit val tt: BusinessFunction = BusinessFunction.this
	) extends BusinessFunctionElementRelationships[BusinessFunction]

	val rel: BusinessFunctionRelationships = BusinessFunctionRelationships()

	case class BusinessFunctionProps(
		override private[semod] implicit val tt: BusinessFunction = BusinessFunction.this
	) extends BusinessFunctionElementProps[BusinessFunction]

	val prop: BusinessFunctionProps = BusinessFunctionProps()

	_registerPrefix("BF")
}
