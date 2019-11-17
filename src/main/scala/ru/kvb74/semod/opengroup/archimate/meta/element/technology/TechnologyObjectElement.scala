package ru.kvb74.semod.opengroup.archimate.meta.element.technology

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessObjectElement

trait TechnologyObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyObjectElement
	extends ElementName

trait TechnologyObjectElementProps[T <: TechnologyObjectElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

trait TechnologyObjectElementRelationships[T <: TechnologyObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: BusinessObjectElement): T = tt._rel.realizes(dst)

	_register(TechnologyObjectElement,
		RR.realizes(BusinessObjectElement)
	)

}
