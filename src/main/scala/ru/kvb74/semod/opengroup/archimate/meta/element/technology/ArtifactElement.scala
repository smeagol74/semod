package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.application.{ApplicationComponentElement, DataObjectElement}

trait ArtifactElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement
		with TechnologyObjectElement

case object ArtifactElement
	extends ElementName

trait ArtifactElementProps[T <: ArtifactElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

trait ArtifactElementRelationships[T <: ArtifactElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def specializationOf(dst: TechnologyObjectElement): T = tt._rel.specializationOf(dst)

	def realizes(dst: SystemSoftwareElement): T = tt._rel.realizes(dst)

	def realizes(dst: DataObjectElement): T = tt._rel.realizes(dst)

	def realizes(dst: ApplicationComponentElement): T = tt._rel.realizes(dst)

	_register(ArtifactElement,
		RR.specializationOf(TechnologyObjectElement),
		RR.realizes(SystemSoftwareElement),
		RR.realizes(DataObjectElement),
		RR.realizes(ApplicationComponentElement),
	)

}