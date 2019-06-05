package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._

trait ArtifactElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyObjectElement

case object ArtifactElement
	extends ElementName

trait ArtifactElementRelationships[T <: ArtifactElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def specializationOf(dst: TechnologyObjectElement): T = tt._rel.specializationOf(dst)

	def realizes(dst: SystemSoftwareElement): T = tt._rel.realizes(dst)

	_register(ArtifactElement,
		JR.specializationOf(TechnologyObjectElement),
		JR.realizes(SystemSoftwareElement)
	)

}