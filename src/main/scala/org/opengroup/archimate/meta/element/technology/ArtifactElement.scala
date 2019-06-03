package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element.{PassiveStructureElement, StrategyCoreStructureBehaviorElement, StrategyCoreStructureBehaviorElementRelationships}

trait ArtifactElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyObjectElement

trait ArtifactElementRelationships[T <: ArtifactElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {
	def isSpecializationOf(dst: TechnologyObjectElement): T = tt._rel.isSpecializationOf(dst)

	def realizes(dst: SystemSoftwareElement): T = tt._rel.realizes(dst)
}