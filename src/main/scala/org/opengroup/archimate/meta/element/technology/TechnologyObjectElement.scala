package org.opengroup.archimate.meta.element.technology

import org.opengroup.archimate.meta.element._
import org.opengroup.archimate.meta.element.business.BusinessObjectElement

trait TechnologyObjectElement
	extends PassiveStructureElement
		with StrategyCoreStructureBehaviorElement

case object TechnologyObjectElement
	extends ElementName

trait TechnologyObjectElementRelationships[T <: TechnologyObjectElement]
	extends StrategyCoreStructureBehaviorElementRelationships[T] {

	def realizes(dst: BusinessObjectElement): T = tt._rel.realizes(dst)

	_register(TechnologyObjectElement,
		JR.realizes(BusinessObjectElement)
	)

}
