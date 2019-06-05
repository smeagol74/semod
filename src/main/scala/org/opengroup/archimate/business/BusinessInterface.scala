package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessInterfaceElement, BusinessInterfaceElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessInterface(
	name: String,
	desc: String = ""
) extends Business
	with BusinessInterfaceElement {

	case class BusinessInterfaceRelationships(
		override private[archimate] implicit val tt: BusinessInterface = BusinessInterface.this
	) extends BusinessInterfaceElementRelationships[BusinessInterface]

	val rel: BusinessInterfaceRelationships = BusinessInterfaceRelationships()

}
