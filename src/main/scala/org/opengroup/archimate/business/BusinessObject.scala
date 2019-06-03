package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessObjectElement, BusinessObjectElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessObject(
	name: String,
	desc: String = ""
) extends Business
	with BusinessObjectElement {

	object rel extends BusinessObjectElementRelationships[BusinessObject] {
		override private[archimate] implicit val tt: BusinessObject = BusinessObject.this
	}

}
