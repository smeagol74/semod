package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait TechnologyObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement

trait TechnologyObjectElementRelationships[T <: TechnologyObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T]
