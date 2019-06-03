package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessRoleElement, BusinessRoleElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessRole(
	name: String,
	desc: String = ""
) extends Business
	with BusinessRoleElement {

	object rel extends BusinessRoleElementRelationships[BusinessRole] {
		override private[archimate] implicit val tt: BusinessRole = BusinessRole.this
	}
}
