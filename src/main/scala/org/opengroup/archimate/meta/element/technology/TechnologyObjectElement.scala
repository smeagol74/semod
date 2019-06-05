package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait TechnologyObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyObjectElement
	extends ElementName

trait TechnologyObjectElementRelationships[T <: TechnologyObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	_register(TechnologyObjectElement)

}
