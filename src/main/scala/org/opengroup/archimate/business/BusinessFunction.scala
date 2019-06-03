package org.opengroup.archimate.business

import org.opengroup.archimate.meta.element.business.{BusinessFunctionElement, BusinessFunctionElementRelationships}
import org.opengroup.archimate.meta.layer.Business

case class BusinessFunction(
	name: String,
	desc: String = ""
) extends Business
	with BusinessFunctionElement {

	object rel extends BusinessFunctionElementRelationships[BusinessFunction] {
		override private[archimate] implicit val tt: BusinessFunction = BusinessFunction.this
	}

}
