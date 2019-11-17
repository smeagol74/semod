package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessProcessElement, BusinessProcessElementProps, BusinessProcessElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class BusinessProcess(
	name: String
) extends BusinessLayer
	with BusinessProcessElement {

	case class BusinessProcessRelationships(
		override private[semod] implicit val tt: BusinessProcess = BusinessProcess.this
	) extends BusinessProcessElementRelationships[BusinessProcess]

	val rel: BusinessProcessRelationships = BusinessProcessRelationships()

	case class BusinessProcessProps(
		override private[semod] implicit val tt: BusinessProcess = BusinessProcess.this
	) extends BusinessProcessElementProps[BusinessProcess]

	val prop: BusinessProcessProps = BusinessProcessProps()

	_registerPrefix("BP")
}
