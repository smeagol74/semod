package ru.kvb74.semod.opengroup.archimate.meta.element.motivation

import ru.kvb74.semod.meta.{ElementName, RR}

trait PrincipleElement
	extends MotivationElement

case object PrincipleElement
	extends ElementName

trait PrincipleElementRelationships[T <: PrincipleElement]
	extends MotivationElementRelationships[T] {

	def realizes(dst: OutcomeElement): T = tt._rel.realizes(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: ValueElement): T = tt._rel.associatedWith(dst)

	// лишнее ограничение уже есть в ElementRelationships
	//	def associatedWith(dst: MeaningElement): T = tt._rel.associatedWith(dst)

	_register(PrincipleElement,
		RR.realizes(OutcomeElement),
		//		JR.associatedWith(ValueElement),
		//		JR.associatedWith(MeaningElement),
	)

}
