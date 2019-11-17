package ru.kvb74.semod.opengroup.archimate.application

import ru.kvb74.semod.opengroup.archimate.meta.element.application.{DataObjectElement, DataObjectElementProps, DataObjectElementRelationships}
import ru.kvb74.semod.opengroup.archimate.meta.layer.ApplicationLayer

case class DataObject(
	name: String
) extends ApplicationLayer
	with DataObjectElement {

	case class DataObjectRelationships(
		override private[semod] implicit val tt: DataObject = DataObject.this
	) extends DataObjectElementRelationships[DataObject]

	val rel: DataObjectRelationships = DataObjectRelationships()

	case class DataObjectProps(
		override private[semod] implicit val tt: DataObject = DataObject.this
	) extends DataObjectElementProps[DataObject]

	val prop: DataObjectProps = DataObjectProps()

	_registerPrefix("ADO")
}