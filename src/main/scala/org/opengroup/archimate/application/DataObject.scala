package org.opengroup.archimate.application

import org.opengroup.archimate.meta.element.application.{DataObjectElement, DataObjectElementRelationships}
import org.opengroup.archimate.meta.layer.Application

case class DataObject(
	name: String,
	desc: String = ""
) extends Application
	with DataObjectElement {

	object rel extends DataObjectElementRelationships[DataObject] {
		override private[archimate] implicit val tt: DataObject = DataObject.this
	}

}