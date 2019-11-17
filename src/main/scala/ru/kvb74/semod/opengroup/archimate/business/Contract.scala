package ru.kvb74.semod.opengroup.archimate.business

import ru.kvb74.semod.opengroup.archimate.meta.element.business.{ContractElement, ContractElementProps, ContractElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.BusinessLayer

case class Contract(
	name: String
) extends BusinessLayer
	with ContractElement {

	case class ContractRelationships(
		override private[semod] implicit val tt: Contract = Contract.this
	) extends ContractElementRelationships[Contract]

	val rel: ContractRelationships = ContractRelationships()

	case class ContractProps(
		override private[semod] implicit val tt: Contract = Contract.this
	) extends ContractElementProps[Contract]

	val prop: ContractProps = ContractProps()

	_registerPrefix("BCn")
}
