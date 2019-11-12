package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{ContractElement, ContractElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Business

case class Contract(
	name: String,
	desc: String = ""
) extends Business
	with ContractElement {

	case class ContractRelationships(
		override private[semod] implicit val tt: Contract = Contract.this
	) extends ContractElementRelationships[Contract]

	val rel: ContractRelationships = ContractRelationships()

	_registerPrefix("BCn")
}
