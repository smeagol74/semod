package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._

trait DataObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object DataObjectElement
	extends ElementName

trait DataObjectElementRelationships[T <: DataObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	_register(DataObjectElement)

}