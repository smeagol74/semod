package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{ContractElement, ContractElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class Contract(
	name: String,
	desc: String = ""
) extends Business
	with ContractElement {

	case class ContractRelationships(
		override private[archimate] implicit val tt: Contract = Contract.this
	) extends ContractElementRelationships[Contract]

	val rel: ContractRelationships = ContractRelationships()

}
