package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessServiceElement, BusinessServiceElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessService(
	name: String,
	desc: String = ""
) extends Business
	with BusinessServiceElement {

	case class BusinessServiceRelationships(
		override private[archimate] implicit val tt: BusinessService = BusinessService.this
	) extends BusinessServiceElementRelationships[BusinessService]

	val rel: BusinessServiceRelationships = BusinessServiceRelationships()

}
