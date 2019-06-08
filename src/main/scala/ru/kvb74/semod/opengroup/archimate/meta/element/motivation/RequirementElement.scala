package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.opengroup.archimate.meta.element.{ElementName, JR}

trait RequirementElement
	extends MotivationElement

case object RequirementElement
	extends ElementName

trait RequirementElementRelationships[T <: RequirementElement]
	extends MotivationElementRelationships[T] {

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	def realizes(dst: PrincipleElement): T = tt._rel.realizes(dst)

	def realizes(dst: OutcomeElement): T = tt._rel.realizes(dst)

	_register(RequirementElement,
		//		JR.associatedWith(ValueElement),
		//		JR.associatedWith(MeaningElement),
		JR.realizes(PrincipleElement),
		JR.realizes(OutcomeElement),
	)

}
