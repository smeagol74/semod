package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._

trait NodeElement
	extends ActiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object NodeElement
	extends ElementName

trait NodeElementRelationships[T <: NodeElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: NodeElement): T = tt._rel.realizes(dst)

	def composedOf(dst: TechnologyInterfaceElement): T = tt._rel.composedOf(dst)

	def composedOf(dst: NodeElement): T = tt._rel.composedOf(dst)

	def aggregates(dst: NodeElement): T = tt._rel.aggregates(dst)

	def assignedTo(dst: TechnologyInternalBehaviorElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: TechnologyEventElement): T = tt._rel.assignedTo(dst)

	def assignedTo(dst: ArtifactElement): T = tt._rel.assignedTo(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: PathElement): T = tt._rel.associatedWith(dst)

	_register(NodeElement,
		RR.realizes(NodeElement),
		RR.composedOf(TechnologyInterfaceElement),
		RR.composedOf(NodeElement),
		RR.aggregates(NodeElement),
		RR.assignedTo(TechnologyInternalBehaviorElement),
		RR.assignedTo(TechnologyEventElement),
		RR.assignedTo(ArtifactElement),
		//		JR.associatedWith(PathElement),
	)
}
