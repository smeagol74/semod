package ru.kvb74.semod.opengroup.archimate.meta.element.application

import ru.kvb74.semod.meta.{ElementName, RR}
import ru.kvb74.semod.opengroup.archimate.meta.element._
import ru.kvb74.semod.opengroup.archimate.meta.element.business.BusinessObjectElement

trait DataObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object DataObjectElement
	extends ElementName

trait DataObjectElementProps[T <: DataObjectElement]
	extends StrategyCoreStructureBehaviorElementProps[T]

trait DataObjectElementRelationships[T <: DataObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: BusinessObjectElement): T = tt._rel.realizes(dst)

	_register(DataObjectElement,
		RR.realizes(BusinessObjectElement)
	)

}