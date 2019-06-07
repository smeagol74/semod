package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{BusinessProcessElement, BusinessProcessElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Business

case class BusinessProcess(
	name: String,
	desc: String = ""
) extends Business
	with BusinessProcessElement {

	case class BusinessProcessRelationships(
		override private[archimate] implicit val tt: BusinessProcess = BusinessProcess.this
	) extends BusinessProcessElementRelationships[BusinessProcess]

	val rel: BusinessProcessRelationships = BusinessProcessRelationships()

}
