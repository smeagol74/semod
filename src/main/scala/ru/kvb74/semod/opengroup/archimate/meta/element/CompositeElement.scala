package ru.kvb74.semod.opengroup.archimate.meta.element

import ru.kvb74.semod.opengroup.archimate.meta.element.motivation.{MeaningElement, RequirementElement, ValueElement}

trait CompositeElement
	extends Element

case object CompositeElement
	extends ElementName

trait CompositeElementRelationships[T <: CompositeElement] extends ElementRelationships[T] {

	def influences(dst: RequirementElement, label: String = ""): T = tt._rel.influences(dst, label)

	def realizes(dst: RequirementElement): T = tt._rel.realizes(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	JR.append(CompositeElement, tt,
		JR.influences(RequirementElement),
		JR.realizes(RequirementElement),
		//		JR.associatedWith(ValueElement),
		//		JR.associatedWith(MeaningElement)
	)
}