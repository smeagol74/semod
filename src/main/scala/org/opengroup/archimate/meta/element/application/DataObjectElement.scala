package org.opengroup.archimate.meta.element.application

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.business.BusinessObjectElement

trait DataObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object DataObjectElement
	extends ElementName

trait DataObjectElementRelationships[T <: DataObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: BusinessObjectElement): T = tt._rel.realizes(dst)

	_register(DataObjectElement,
		JR.realizes(BusinessObjectElement)
	)

}