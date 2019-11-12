package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{DataObjectElement, DataObjectElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.Application

case class DataObject(
	name: String,
	desc: String = ""
) extends Application
	with DataObjectElement {

	case class DataObjectRelationships(
		override private[semod] implicit val tt: DataObject = DataObject.this
	) extends DataObjectElementRelationships[DataObject]

	val rel: DataObjectRelationships = DataObjectRelationships()

	_registerPrefix("ADO")
}